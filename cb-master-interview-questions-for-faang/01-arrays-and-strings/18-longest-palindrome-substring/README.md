# Longest Palindrome Substring

Given a string str, find the longest palindromic substring in str. You may assume that the maximum length of s is 1000.

### Input Format

First line contains an integer T, next t line contains string.

### Constraints

```
1<=|s.length()|<=1e3
```

### Output Format

Single line containing single integer

### Sample Input

```
1
asdfghjklmnbvcxz
```

### Sample Output

```
a
```

### Explanation

**Algorithm** :

PreProcess String:

- The first step of the algorithm is to pre-process a given string S, into string T, by inserting a special character between every character of S and also at both ends. For the algorithm future convenience, a distinct special character should then be placed at both ends. This preprocessing is done just to handle both even and odd sized S strings.

- If say, `#` is used as the main special character, these are some examples of the original strings and their resulting transformations :
  - For Example: Str = "abac", Transformed String = "^#a#b#a#c#$"

Process String :

- After having pre-processed a given string S into string T, the next step is to process string T itself. To do that, an auxilliary array P with size equal to the length of T is required.

- The content of the ith element of P corresponds to the size of the maximum expansion to both sides of the ith element of T in order to form a palindrome.

Illustration :

- Transformed String = ^ # a # b # a # c # $
- Palindrome array (P) = 0 0 1 0 3 0 1 0 1 0 0

- An auxiliary variable maxPalCenterID is maintained with the index of the highest value in P and updated while P is populated.

- Since there is a special character at the start of T due to the pre-processing, and also another special character between every character of S, the palindrome start index is given by the formula below.

```
palStartID = (maxPalCenterID - 1 - P[maxPalCenterID]) / 2
```

- Now substring with longest palindrome can be easily fetched as:-

```
substring(palStartID, palStartID + P[maxPalCenterID])
```

### Time Complexity

```
O(n^2)
```
