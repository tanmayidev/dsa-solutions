class ArrayWrapper {
    private nums: number[];

    constructor(nums: number[]) {
        // Validate input to ensure it's an array of numbers
        if (!Array.isArray(nums) || !nums.every(n => Number.isInteger(n))) {
            throw new Error("Input must be an array of integers.");
        }
        this.nums = nums;
    }

    // Called when object is used in arithmetic operations
    valueOf(): number {
        return this.nums.reduce((sum, num) => sum + num, 0);
    }

    // Called when object is converted to string
    toString(): string {
        return JSON.stringify(this.nums);
    }
}