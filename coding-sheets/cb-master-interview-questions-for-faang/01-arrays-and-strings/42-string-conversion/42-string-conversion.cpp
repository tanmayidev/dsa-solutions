#include <bits/stdc++.h>
using namespace std;

class Solution {

public:
bool isOneEditDistance(string s1, string s2) {
  int m = s1.size();
  int n = s2.size();

  if(abs(m - n) > 1) {
    return false;
  }
  
  int k=0,i=0,count=0;
  while(i < m && k < n) {

    if(s1[i] != s2[k]) {
      if(count == 1) {
        return false;
      }
      if(m > n) {
        i++;
      } else if(m < n) {
        k++;
      } else {
        i++;
        k++;
      }
      count++;
    } 
    else {
      i++;
      k++;
    }
  }

  if(i < m || k < n) {
    count++;
  }

  return count == 1;
  }
};

string stringToString(string input) {
  
  assert(input.length() >= 2);
  string result;
  
  for (int i = 1; i < input.length() -1; i++) {
    char currentChar = input[i];

    if (input[i] == '\\') {
      char nextChar = input[i+1];

      switch (nextChar) {
        case '\"': 
          result.push_back('\"'); 
          break;
        case '/' : 
          result.push_back('/'); 
          break;
        case '\\': 
          result.push_back('\\'); 
          break;
        case 'b' : 
          result.push_back('\b'); 
          break;
        case 'f' : 
          result.push_back('\f'); 
          break;
        case 'r' : 
          result.push_back('\r'); 
          break;
        case 'n' : 
          result.push_back('\n'); 
          break;
        case 't' : 
          result.push_back('\t'); 
          break;
        default: 
          break;
      }
      i++;
    } else {
      result.push_back(currentChar);
    }
  }
  return result;
}

string boolToString(bool input) {
  return input ? "True" : "False";
}

int main() {
  string line;
  getline(cin, line);
  
  string s = stringToString(line);
  getline(cin, line);
  
  string t = stringToString(line);
  bool ret = Solution().isOneEditDistance(s, t);

  string out = boolToString(ret);
  cout << out << endl;
  return 0;
}