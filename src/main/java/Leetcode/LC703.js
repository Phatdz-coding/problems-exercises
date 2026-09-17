class KthLargest {
    /**
     * 
     * @param {number} k 
     * @param {number[]} nums 
     */
    constructor(k, nums) {
        this.k = k
        this.nums = nums
        nums.sort((a, b) => a - b) // sort array in ascending order
    }

    /**
     * 
     * @param {number} val 
     * @returns {number}
     */
    add(val) {
        for (let i = 0; i < this.nums.length; i++) {
            if (this.nums[i] >= val) {
                this.nums.splice(i, 0, val);
                break;
            }
            else if (i === this.nums.length - 1) {
                nums.push(val)
                break;
            }
        }
        var index = this.nums.length - this.k
        if (index < 0) {
            throw new RangeError("Index out of bound: index = " + index)
        }
        return this.nums[index]
    }
}


const k = 3
const nums = [4, 5, 8, 2]
const obj = new KthLargest(k, nums)

console.log(result.add(3));
console.log(result.add(5));
console.log(result.add(10));
console.log(result.add(9));
console.log(result.add(4));
