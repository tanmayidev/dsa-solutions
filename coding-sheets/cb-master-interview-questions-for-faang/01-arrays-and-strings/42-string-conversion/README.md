# String Conversion

Jake loves to play with strings, he has two such strings s1 and s2. He wants to check whether both the strings are unit edit distance apart. Unit edit distance means doing one of these operation:

- insert one character in any position of S
- delete one character in S
- change one character in S to other character

### Input Format

```
Two lines containing two strings s1 and s2.
```

### Constraints

```
None
```

### Output Format

```
True if strings are unit distance apart else False.
```

### Sample Input

```
"teacher"
"cher"
```

### Sample Output

```
False
```

#### Time Complexity

```
O(n)
```

#### Space Complexity

```
O(1)
```

### Explanation

**Naive Approach** :
Find edit distance using dynamic programming and if the edit distance comes out to be 1 then return true.

Time Complexity : O(m \* n) where m and n are lengths of two strings.

**Optimized Approach** :

- Check if the difference between the lengths of two strings m and n are greater than 1, then return false i.e a single unit edit distance is not possible.

- Initialize the edit count to 0.
- Traverse both the strings character by character.
- If character of first string s1[i] is not equal to character of second string s2[j], then:

- Edge Case :-

  - If count is 1, return false, i.e edit distance will exceed 1.

- Delete Character Case:-

  - If s1(length) is greater than s2(length), then the only possible element is to delete a character from s1. So increment i by 1.
  - Else if increment j by 1 in case s2(length) is greater than s1(length).

- Change Character:-

  - Else if both the strings are of equal length, increment both i and j, denoting change in character.
  - Increment count by 1.
  - If s1[i] is equal to s2[j], then increment both i and j by 1.

- Edge Case :-

  - If the last character is extra in any string, then increment count because the only operation which can be performed is deletion of that character.
  - If count is 1 return true, else return false.

- Time Complexity:- O(n)
- Space Complexity:- O(1)
