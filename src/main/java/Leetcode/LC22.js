class MyQueue {
    constructor() {
        this.items = [];
    }

    enqueue(element) {
        this.items.push(element);
    }

    dequeue() {
        return this.isEmpty() ? null : this.items.shift();
    }

    isEmpty() {
        return this.items.length === 0;
    }

    print() {
        console.log(this.items.join(" -> "));
    }
}

/**
 * 
 * @param {string} str 
 * @returns {number}
 */
function countOpen(str) {
    let r = 0
    for (let i = 0; i < str.length; i++) {
        if (str[i] === '(') r++
    }
    return r
}

/**
 * 
 * @param {string} str 
 * @returns {number}
 */
function countClose(str) {
    let r = 0
    for (let i = 0; i < str.length; i++) {
        if (str[i] === ')') {
            r++
        }
    }
    return r
}

/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function (n) {
    let result = []

    let q = new MyQueue()
    q.enqueue("(")

    while (!q.isEmpty()) {
        let cur = q.dequeue()
        let open = countOpen(cur)
        let close = countClose(cur)

        if (open === n && close !== n) {
            q.enqueue(cur + ')')
        }
        else if (open < n) {
            q.enqueue(cur + '(')
            if (open > close) {
                q.enqueue(cur + ')')
            }
        }
        else if (!result.includes(cur)) {
            result.push(cur)
        }

        // console.log(q);
    }

    return result
};

const obj = generateParenthesis(3)

console.log(result);
