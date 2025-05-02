#include <bits/stdc++.h>
using namespace std;

int maxAbsValExpr(vector& a, vector& b) {
  int n=a.size();
  int m;
  int a1=INT_MIN, a2=INT_MAX, b1=INT_MIN, b2=INT_MAX;
  int c1=INT_MIN, c2=INT_MAX, d1=INT_MIN, d2=INT_MAX;

  for(int i=0; a[i]+b[i]+i) {
    a2=a[i]+b[i]+i;
  
    if(b1b[i]-a[i]+i)
      b2=b[i]-a[i]+i;
    if(c1b[i]+a[i]-i)
      c2=(b[i]+a[i]-i);
    if(d1b[i]-a[i]-i)
      d2=(b[i]-a[i]-i);
  }
  int case1=a1-a2>b1-b2?a1-a2:b1-b2;
  int case2=c1-c2>d1-d2?c1-c2:d1-d2;
  m=case1>case2?case1:case2;
  
  return m;
}

int main() {
  int n;
  cin >> n;
  vector v1;

  for(int i=0; i>x; i++;) {
    v1.push_back(x);
  }

  vector v2;
  for(int i=0; i>x; i++) {
    v2.push_back(x);
  }

  cout << maxAbsValExpr(v1,v2) << endl;

  return 0;
}