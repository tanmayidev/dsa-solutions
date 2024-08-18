# Majority_Element

You have to given an array A of size N.
Find all the elements which appear more than floor(N/3) times in the given array.
There is a condition that you have to do your job in O(N) time complexity and O(1) space complexity.
Input Format
First line contains N ->No. of elements in the array
Second line has N integers denoting the elements of the array A ie A1,A2,A3.......AN.
Constraints
1<=N<=10^7
0<=Ai<=10^9
Output Format
Print a single line containing all the majority elements occurring more than floor(N/3) times.
If there is no majority element then just print "No Majority Elements".
Sample Input
8
2 2 3 1 3 2 1 1
Sample Output
1 2
Explanation
None
Find Majority Elements
To solve this question in O(n) time complexity and O(1) space complexity, we use Moore’s Voting
Algorithm.
This is a two-step process.
-> The first step gives the element that maybe the majority element in the array. If there is a
majority element in an array, then this step will definitely return majority element, otherwise, it will
return candidate for majority element.
-> Check if the element obtained from the above step is majority element. This step is necessary as
there might be no majority element.
Algorithm:

1. Loop through each element and maintains a count of majority element, and a majority
   index, maj_index
2. If the next element is same then increment the count if the next element is not same then
   decrement the count.
3. If the count reaches 0 then changes the maj_index to the current element and set the count
   again to 1.
4. Now again traverse through the array and find the count of majority element found.
5. If the count is greater than floor(N/3) then this element will be one of the majority
   elements.
6. Else print nothing.
