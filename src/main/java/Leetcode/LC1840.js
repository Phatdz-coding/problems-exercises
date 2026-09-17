

/**
 * @param {number} n
 * @param {number[][]} restrictions
 * @return {number}
 */
var maxBuilding = function (n, restrictions) {
    if (restrictions.length === 0) {
        return n
    }
    // sor the restrictions
    restrictions.sort((a, b) => a[0] - b[0])

    let cur_height = 0
    let max_height = -Infinity
    let j = 0
    let max_height_index = 0
    let restriction = -1
    for (let i = 2; i <= n; i++) {
        restriction = -1
        if ((restrictions.at(j))[0] === i) {
            restriction = restrictions[j++][1]
        }

        if (cur_height < restriction || restriction === -1) {
            cur_height++
            if (cur_height > max_height) {
                max_height = cur_height
                max_height_index = i
            }
        }
        else if (cur_height > restriction) {
            cur_height = restriction

            // update max height
            if (restrictions[j - 1][0] > max_height_index && restrictions[j - 2][0] < max_height_index) {
                max_height_index = restrictions[j - 2][0] + 1
                max_height = restrictions[j-2][1] + 1
            }
        }

    }

    return max_height
};


const n = 10
const restrictions = [[8, 5], [9, 0], [6, 2], [4, 0], [3, 2], [10, 0], [5, 3], [7, 3], [2, 4]]

max = maxBuilding(n, restrictions)

console.log(max);
