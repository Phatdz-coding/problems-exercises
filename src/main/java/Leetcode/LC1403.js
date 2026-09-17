/**
 * Calculate the sum of all integer elements in an array.
 *
 * @param {number[]} nums
 * @return {number}
 */
function sum(nums) {
    let sum = 0;
    for (let i = 0; i < nums.length; i++) {
        sum += nums[i];
    }
    return sum;
}

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var minSubsequence = function (nums) {
    nums.sort((a, b) => b - a)
    const total = sum(nums)
    let cur_sum = 0
    let r = []
    for (const n of nums) {
        r.push(n)
        cur_sum += n

        if (cur_sum > total - cur_sum) {
            return r
        }
    }
};

// Example usage
const a = [4, 4, 4, 7, 6, 7];

console.log(minSubsequence(a));


