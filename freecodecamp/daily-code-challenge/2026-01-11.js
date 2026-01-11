```
Par for the Hole
Given two integers, the par for a golf hole and the number of strokes a golfer took on that hole, return the golfer's score using golf terms.

Return:
"Hole in one!" if it took one stroke.
"Eagle" if it took two strokes less than par.
"Birdie" if it took one stroke less than par.
"Par" if it took the same number of strokes as par.
"Bogey" if it took one stroke more than par.
"Double bogey" if took two strokes more than par.

Test Cases : 
1. golfScore(3, 3) should return "Par".
2. golfScore(4, 3) should return "Birdie".
3. golfScore(3, 1) should return "Hole in one!".
4. golfScore(5, 7) should return "Double bogey".
5. golfScore(4, 5) should return "Bogey".
6. golfScore(5, 3) should return "Eagle".

```

function golfScore(par, strokes) {

  // if (strokes == 1) {
  //   return "Hole in one!";
  // } else if ((par - strokes) == 2) {
  //   return "Eagle";
  // } else if ((par - strokes) == 1) {
  //   return "Birdie";
  // } else if ((par - strokes == 0)) {
  //   return "Par";
  // } else if ((par - strokes) == -1) {
  //   return "Bogey";
  // } else if ((par - strokes) == -2) {
  //   return "Double bogey"
  // }

  if (strokes == 1) {
     return "Hole in one!";
  }
  let diff = par - strokes;

  switch(diff) {
    case 0:
      return "Par";
    case 1:
      return "Birdie";
    case 2:
      return "Eagle";
    case -1:
      return "Bogey";
    case -2:
      return "Double bogey";
    default:
      return "";
  }

}
