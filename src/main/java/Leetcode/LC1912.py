from typing import List
from collections import defaultdict


class MovieRentingSystem:
    def __init__(self, n: int, entries: List[List[int]]):
        self.movies_by_id = defaultdict(list)
        self.price_by_key = {}
        self.rented = set()

        for shop, movie, price in entries:
            self.movies_by_id[movie].append((price, shop))
            self.price_by_key[(shop, movie)] = price

        for movie in self.movies_by_id:
            self.movies_by_id[movie].sort()

    def search(self, movie: int) -> List[int]:
        result = []
        for price, shop in self.movies_by_id[movie]:
            if (shop, movie) not in self.rented:
                result.append(shop)
                if len(result) == 5:
                    break
        return result

    def rent(self, shop: int, movie: int) -> None:
        self.rented.add((shop, movie))

    def drop(self, shop: int, movie: int) -> None:
        self.rented.discard((shop, movie))

    def report(self) -> List[List[int]]:
        rented_movies = sorted(
            ((self.price_by_key[(shop, movie)], shop, movie) for shop, movie in self.rented)
        )
        return [[shop, movie] for _, shop, movie in rented_movies[:5]]

entries = [
    [13, 6406, 5183],
    [10, 2926, 931],
    [0, 6424, 7126],
    [0, 4988, 4028],
    [6, 8295, 7660],
    [16, 4729, 3008],
    [7, 6349, 8844],
    [1, 6896, 3047],
    [8, 4693, 3264],
    [13, 1984, 6267],
    [14, 4544, 5627],
    [21, 6347, 1327],
    [7, 4932, 3085],
    [16, 5577, 1542],
    [11, 9549, 2609],
    [5, 8830, 5502],
    [19, 3157, 6780],
    [1, 7953, 5964],
    [7, 1882, 6571],
    [18, 9932, 1146],
    [17, 5985, 2625],
    [19, 8434, 4176],
    [19, 1762, 3420],
    [13, 2558, 984],
    [4, 4693, 6178],
    [17, 6347, 3059],
    [17, 5808, 1467],
    [21, 7778, 1596],
    [1, 47, 7419],
    [15, 646, 8719],
    [10, 1694, 9782],
    [6, 5577, 5867],
    [11, 6406, 4180],
    [12, 6347, 7325],
    [1, 1112, 8378],
    [8, 6750, 3274],
    [12, 531, 8300],
    [8, 7672, 6253],
    [17, 5551, 6090],
    [14, 4321, 597],
    [16, 8872, 2453],
    [5, 9630, 3367],
    [7, 8872, 9900],
    [16, 3238, 5601],
    [9, 9630, 9659],
    [12, 431, 2143],
    [13, 646, 6596],
    [12, 7953, 1106],
    [17, 1564, 5806],
    [9, 4988, 2545],
    [20, 3852, 3190],
    [16, 7953, 7802],
    [19, 646, 7631],
    [21, 9816, 46],
    [11, 7778, 37],
]

s = MovieRentingSystem(len(entries), entries)

print(s.search(1))

s.rent(0, 1)
s.rent(1, 2)
print(s.unrented_movies)
print(s.rented_movies)

print(s.report())

s.drop(1, 2)
print(s.unrented_movies)
print(s.rented_movies)

print(s.search(2))
