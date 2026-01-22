function getAverageGrade(scores) {

  const sum = scores.reduce((acc, score) => acc + score, 0);
  const average = sum / scores.length;
  
  if (average >= 97) return "A+";
  if (average >= 93) return "A";
  if (average >= 90) return "A-";
  if (average >= 87) return "B+";
  if (average >= 83) return "B";
  if (average >= 80) return "B-";
  if (average >= 77) return "C+";
  if (average >= 73) return "C";
  if (average >= 70) return "C-";
  if (average >= 67) return "D+";
  if (average >= 63) return "D";
  if (average >= 60) return "D-";
  return "F";
}
