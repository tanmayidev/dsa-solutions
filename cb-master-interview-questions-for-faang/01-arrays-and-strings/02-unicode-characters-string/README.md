# Unicode Characters String

Ramu has an array of strings. He want to find a string s such that it is a concatenation of sub-sequence of given array and have unique characters.Since,he has just started coding so he needs your help.

A sub-sequence of an array is a set of elements that can be obtained by deleting some
elements(posssibly none) from the array and keeping the order same.

Print the maximum possible length of s.

### Input Format

The first line of input contains an interger n -the length of array.Next n lines contains the element(strings) of the array

### Constraints

```
1 <= n <= 18
1 <= arr[i].length<= 26
```

### Output Format

Print one integer - the maximum length of s.

### Sample Input

```
3
ab
cd
ab
```

### Sample Output

```
4
```

### Algorithm:

1. We will solve this problem through recursion.
2. So, iterate from left to right and try every string as a starting string.
3. Keep a set of character that stores characters that have occurred till now.
4. Once,you have selected a string as a starting string,now for every other string you have 2 options:

   - To add that string(only if all its characters have not occurred before) and add its character to
     set of current characters.
   - To leave that string 5.Try the same for all string and finally return maximum of them.

5. Try the same for all string and finally return maximum of them.

### Time Complexity:

2^n where n is the number of elements in the array.
