# Compose Versions

Given two version numbers, version1 and version2, compare them. <br>

Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.
<br>
To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but
their revision 1s are 0 and 1 respectively, and 0 < 1.

<br>
Given two versions, your task is to:
print 1 if version1>version 2
print -1 if version1 < version2
print 0 if version1=version2.
For ex: 1.0.1.6 > 1 and 1.000=1.
Note: You have to ignore leading zeroes.

### Input Format

```
2 lines will contain 2 strings, version 1 on first line and version 2 on second line.
```

### Constraints

```
String length <= 1000
```

### Output Format

```
Print on a single line either -1 or 0 or 1.
```

### Sample Input

```
1.0.1.6
1
```

### Sample Output

```
1
```

### Explanation

**Algorithm** :

We take two variables num1 and num2 and then simply iterate over the 2 strings until a ‘.’ character is encountered. We also keep adding the current value to 10num1 and 10num2,
this way we will get the numbers between 2 points(‘.’) and then we can easily compare num1 and num2. We repeat this process until the end of the process and again initialise num1=0 and num2=0 after the starting of each ‘.’ character.
<br>
Note: Here we will return 0 only after coming of the loop as it is possible that num1 and num2 are
equal for a particular region but in the next region they become unequal. For eg: 12.34 & 12.43

### Time Complexity
