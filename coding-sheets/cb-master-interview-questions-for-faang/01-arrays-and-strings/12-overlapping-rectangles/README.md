# Overlapping Rectangles

A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner, and (x2, y2) are the coordinates of its top-right corner.

Two rectangles overlap if the area of their intersection is positive. To be clear, two rectangles that only touch at the corner or edges do not overlap.

Given two (axis-aligned) rectangles, return whether they overlap.

### Input Format

First line contains an 4 integers i.e x1, y1, x2, y2 for rectangle 1, similarly second line contains coordinates for rectangle 2.

### Constraints

None

### Output Format

1 if rectangles overlap else 0.

### Sample Input

```
0 0 1 1
1 0 2 1
```

### Sample Output

```
0
```

### Explanation

**Algorithm** :

- If the rectangles do not overlap, then rec1 must either be higher, lower, to the left, or to the right of rec2.

So the conditions that the two rectangles will not overlap will be as follows:-

If rec1 left of rec2:
rec1[2] <= rec2[0], i.e rightmost x coordinate of rec1 is smaller than or equal to the leftmost x coordinate of rec2.

OR

If rec1 is right of rec2:
rec1[0] >= rec2[2], i.e leftmost x coordinate of rec1 is greater than or equal to the rightmost x coordinate of rec2.

OR

If rec1 is above of rec2:
rec1[1] >= rec2[3], i.e leftmost y coordinate of rec1 is greater than or equal to rightmost y coordinate of rec2.

OR

If rec1 is below of rec2:
rec1[3] <= rec2[1], i.e rightmost y coordinate of rec1 is lesser than or equal to leftmost y coordinate of rec2.

The negation of these 4 conditions will be the condition for rectangles to overlap i.e !(cond1 || cond2 || cond3 || cond4).

### Time Complexity

```
O(1)
```

### Space Complexity

```
 O(1)
```
