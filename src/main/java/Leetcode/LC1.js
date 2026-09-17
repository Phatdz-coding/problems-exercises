class MyHashTable {
    constructor() {
        this.table = new Map();
    }

    insert(num) {
        this.table.set(num, (this.table.get(num) || 0) + 1);
    }

    insertArray(nums) {
        nums.forEach(n => {
            this.insert(n)
        });
    }

    contains(num) {
        return this.table.has(num);
    }

    count(num) {
        return this.table.get(num) || 0;
    }

    values() {
        return [...this.table.keys()];
    }
}

function buildIntHashTable(nums) {
    const hashTable = new MyHashTable();
    for (const num of nums) {
        hashTable.insert(num);
    }
    return hashTable;
}


/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
*/
var twoSum = function (nums, target) {
    const ht = new MyHashTable()
    ht.insertArray(nums)
    
    for (let i = 0; i < nums.length; i++) {
        let k = target - nums[i]
        
        if (ht.contains(k)) {
            for (let j = 0; j < nums.length; j++) {
                if (nums[j] === k && j !== i) {
                    return [i,j]
                }
                
            }
        }
    }
};

const nums = [3,3];
let result = twoSum(nums, 6)

console.log(result);
