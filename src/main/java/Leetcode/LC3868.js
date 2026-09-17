class MyHashTable {
    constructor(capacity = 16) {
        if (capacity <= 0) throw new Error('capacity must be > 0');
        this.capacity = capacity;

        // Open addressing (linear probing)
        this.keys = new Array(capacity);
        this.values = new Array(capacity); // count
        this.used = new Array(capacity).fill(false);
        this.length = 0;
    }

    _hash(key) {
        const str = String(key);
        let h = 0;
        for (let i = 0; i < str.length; i++) {
            h = (h * 31 + str.charCodeAt(i)) | 0;
        }
        return ((h % this.capacity) + this.capacity) % this.capacity;
    }

    // add(key): increments occurrence count for key; returns updated count
    add(key) {
        let idx = this._hash(key);

        for (let step = 0; step < this.capacity; step++) {
            if (!this.used[idx]) {
                this.used[idx] = true;
                this.keys[idx] = key;
                this.values[idx] = 1;
                this.length++;
                return 1;
            }

            if (this.keys[idx] === key) {
                this.values[idx] += 1;
                return this.values[idx];
            }

            idx = (idx + 1) % this.capacity;
        }

        throw new Error('Hashtable is full (increase capacity).');
    }

    // return list of [key, value] (no chaining display)
    entries() {
        const res = [];
        for (let i = 0; i < this.capacity; i++) {
            if (this.used[i]) res.push([this.keys[i], this.values[i]]);
        }
        return res;
    }

    get(key) {
        let idx = this._hash(key);

        for (let step = 0; step < this.capacity; step++) {
            if (!this.used[idx]) return undefined;
            if (this.keys[idx] === key) return this.values[idx];
            idx = (idx + 1) % this.capacity;
        }

        return undefined;
    }

    delete(key) {
        let idx = this._hash(key);

        for (let step = 0; step < this.capacity; step++) {
            if (!this.used[idx]) return false; // not found

            if (this.keys[idx] === key) {
                // remove entry at idx
                this.used[idx] = false;
                this.keys[idx] = undefined;
                this.values[idx] = undefined;
                this.length--;

                // rehash subsequent cluster to preserve probing correctness
                idx = (idx + 1) % this.capacity;
                for (let reStep = 0; reStep < this.capacity; reStep++) {
                    if (!this.used[idx]) break;

                    const reKey = this.keys[idx];
                    const reVal = this.values[idx];

                    // clear slot
                    this.used[idx] = false;
                    this.keys[idx] = undefined;
                    this.values[idx] = undefined;
                    this.length--;

                    // re-insert with stored count
                    // (use add multiple times via direct placement)
                    // We'll place directly to avoid repeated increments.
                    let placeIdx = this._hash(reKey);
                    for (let p = 0; p < this.capacity; p++) {
                        if (!this.used[placeIdx]) {
                            this.used[placeIdx] = true;
                            this.keys[placeIdx] = reKey;
                            this.values[placeIdx] = reVal;
                            this.length++;
                            break;
                        }
                        if (this.keys[placeIdx] === reKey) {
                            this.values[placeIdx] += reVal;
                            break;
                        }
                        placeIdx = (placeIdx + 1) % this.capacity;
                    }

                    idx = (idx + 1) % this.capacity;
                }

                return true;
            }

            idx = (idx + 1) % this.capacity;
        }

        return false;
    }

}



/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var minCost = function (nums1, nums2) {
    let ht1 = new MyHashTable(nums1.length)
    let ht2 = new MyHashTable(nums2.length)

    for (const n of nums1) {
        ht1.add(n)
    }

    for (const n of nums2) {
        ht2.add(n)
    }

    // console.log(ht1.entries());
    // console.log(ht2.entries());

    let total_dif = 0
    for (const element of ht1.entries()) {
        const f1 = element[1]
        let f2 = ht2.get(element[0])
        if (f2 == undefined) {
            total_dif += f1
            continue
        }
        ht2.delete(element[0])

        // console.log(f1 + " - " + f2);
        if ((f1 + f2) % 2 !== 0) {
            return -1
        }

        total_dif += Math.abs(f1 - f2)
    }

    for (const element of ht2.entries()) {
        if (element[1] % 2 !==2) {
            return -1
        }
        total_dif += element[1]
    }

    return total_dif / 4
};

const nums1 = [10, 10]
const nums2 = [20, 20]

let cost = minCost(nums1, nums2)

console.log(cost);
