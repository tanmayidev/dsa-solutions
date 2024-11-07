# Pancake Sorting

Sharadh bhaiya is playing a game of pancakeflip .He has given his students an array 'A' in which they can perform a pancake flip.The task is to choose some positive integer k<= A.length, then reverse the order of the first k elements of A. Return the k-values corresponding to a sequence of pancake flips that sort A.

Note:Any valid answer that sorts the array within 10 \* A.length flips will be judged as correct.

### Input Format

You do not have to take any input or print any output exactly. Simply write the given function. Your function takes the array for each testcase as input.

### Constraints

```
1 <= T <= 100
1 <= A.length <= 100 A[i] is a permutation of [1, 2, ..., A.length]
```

### Output Format

The function should return a single array which contains a valid pancake sort. Any valid pancake sort will work.

### Sample Input

```
1
4
3 2 4 1
```

### Sample Output

```
3 4 2 3 1 2
```

### Explanation

We choose some positive integer k <= A.length, then reverse the order of the first k elements of A. We want to perform zero or more pancake flips (doing them one after another in succession)
to sort the array A.

**Algorithm** :

- We first need to assume that all the elements present in the array of size n are between 1 to n.

- Make an ArrayList of Integer

- Find the size of teh array and store in a variable `n`

- We will iterate over the whole array

- main logic

```cpp
while(n > 0)
{
  // find the index of N in given array
  int i = find(array, n);
  // if a bigger number is at last index of array no need to flip
  if(i !== n-1) {
    flip(a, i+1);
    flip(a, n);
    ans.add(i+1);
    ans.add(n);
  }
  n--;
}

return ans;
```

- flip function

```cpp
flip(int a[], int f) {
  for(int i=0; i< k/2; i++) {
    int t = a[i];
    a[i] = a[k-i-1];
    a[k-i-1] = t;
  }
}
```

- For example, for a pancake flip f, if i < f/2>=, then the element has moved from location i to f+1-i

### Time and Space Complexity

```
Time Complexity: O(N^2)
Space Complexity: O(N)
```
