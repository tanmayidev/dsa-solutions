/*

Given an integer n, return the nth number in the fibonacci sequence.

The Fibonacci sequence is a series of numbers where each number is the sum of the two preceding ones. 
The first 10 numbers in the sequence are 0, 1, 1, 2, 3, 5, 8, 13, 21, 34.

Tests:
1. nthFibonacci(4) should return 2.
2. nthFibonacci(10) should return 34.
3. nthFibonacci(15) should return 377.
4. nthFibonacci(40) should return 63245986.
5. nthFibonacci(75) should return 1304969544928657.

*/

function nthFibonacci(n) {
  if(n == 0) {
    return 0;
  } else if(n == 1) {
    return 1;
  } 

  return nthFibonacci(n-1) + nthFibonacci(n-2);
}
