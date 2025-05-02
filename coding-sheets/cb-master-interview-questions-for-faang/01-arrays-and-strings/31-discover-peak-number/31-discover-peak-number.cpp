#include <bits/stdc++.h>
using namespace std;

bool search(int * nums, int l, int r) {
  if(l>r) {
    return false;
  }
  if (l == r)
    return true;
  
  int mid = (l + r) / 2;
  if (nums[mid] > nums[mid + 1])
    return search(nums, l, mid);
  
  return search(nums, mid + 1, r);
}

int main() {
  // cout<<"Hello World!";
  int n;
  cin>>n;
  int arr [n];
  
  for(int i=0; i<n; i++) {
  cin>>arr[i];
  }
  
  bool b= search(arr, 0, n-1);
  if(b==1)
    cout<<"true"<<endl;
  else
    cout<<"false"<<endl;
}