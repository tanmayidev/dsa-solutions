/*
Leap Year Calculator
Given an integer year, determine whether it is a leap year.

A year is a leap year if it satisfies the following rules:
- The year is evenly divisible by 4, and
- The year is not evenly divisible by 100, unless
- The year is evenly divisible by 400.

Test Cases : 
1. is_leap_year(2024) should return True.
2. is_leap_year(2023) should return False.
3. is_leap_year(2100) should return False.
4. is_leap_year(2000) should return True.
5. is_leap_year(1999) should return False.
6. is_leap_year(2040) should return True.
7. is_leap_year(2026) should return False

*/

function isLeapYear(year) {

  if(year%4 == 0 && (year%100 !== 0 || year%400 == 0)) {
    return true;
  }

  return false;
}
