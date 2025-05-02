# Overhappy Numbers

A 'overhappy' number follows the following criteria:

It is always a positive integer. The integer number is replaced by the sum of the squares of its digits and this process is repeated until the sum equals 1.

The numbers which loop endlessly and never reach to the sum of 1 are not overhappy numbers.

### Input Format

```
First line contains an positive integer n.
```

### Constraints

```
None
```

### Output Format

```
Print true if n is overhappy number else print false.
```

### Sample Input

```
19
```

### Sample Output

```
true
```

### Time Complexity

```
O(n)
```

### Explanation

**Algorithm** :
A number will not be a Happy Number when it makes a loop in its sequence that is it
touches a number in sequence which already been touched. So to check whether a number is happy or not, we can keep a unordered map, if same number occurs again we flag result as not happy. A simple algorithm on above approach can be written as below :

**Step 1:** Initialize one variable n (int n)and pass it to a function isHappy(n) and if isHappy(n) function returns true print 1 else print 0.

**Step 2:** Inside the isHappy function which is of type boolean declear an unordered map ‘mp’ of key as integer type and value of boolean type. This map will keep track whether the same number has occured before or not and also declear a variable ‘a’ of integer type which initially stores the value of n(int a=n).

```
Bool isHappy(int n)
unordered_map mp
```

**Step 3:** Loop till the same number has not occured before and inside the loop the declear value of ‘a’ as true.

```
mp[a]=true
```

**Step 4:** Inside the loop Make another function ‘cal’ and pass ‘a’ as parameter cal(a) and store the returned value from the function in a.(updating value of ‘a’). `a=cal(a) Int cal(int a)`

**Step 5:**

‘Cal’ function will calculate the sum of square of digits of a number as:

- Inside Cal function declear a variable ans =0 and loop till value of ‘a’ is not equal to zero and when value of a becomes zero return ans.
- Everytime get the last digit of the number ‘a’ by modulus operation (`int d = a % 10`) and then Divide ‘a’ by 10 (`a = a/10`). Also update the ans as ans=ans+d\*d.

**Step 6:** If the returned ans from ‘cal’ function is equal to 1 then from the boolean function ‘isHappy’ return true .

**Step 7:** Else if the number returned from ‘cal’ function has not occured before repeat from Step 4 and if the number has occured before return false from the ‘isHappy’ function.
