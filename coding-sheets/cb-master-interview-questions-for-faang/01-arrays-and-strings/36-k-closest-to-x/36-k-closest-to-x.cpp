#include <bits/stdc++.h>
using namespace std;


vector<int> findClosestElements(vector<int>& arr, int k, int x) {
  int n=arr.size();
  int cur_sum=0,pos=0;

  for(int i=0;i<k;i++) {
    cur_sum+=abs(x-arr[i]);
  }
  
  int sum=cur_sum;
  for(int i=1;i<=n-k;i++) {
    cur_sum-=abs(x-arr[i-1]);
    cur_sum+=abs(x-arr[i+k-1]);
    
    if(cur_sum<sum) {
      sum=cur_sum;
      pos=i;
    }
  }
  
  vector<int> ans;
  for(int i=0;i<k;i++) {
    ans.push_back(arr[i+pos]);
  }
  return ans;
}

int main() {
  int n,k,x;
  cin>>n;
  vector<int> arr;

  for(int i=0;i<n;i++) {
    int num;
    cin>>num;
    arr.push_back(num);
  }
  cin>>k>>x;

  vector<int> res=findClosestElements(arr,k,x);

  for(int i=0;i<k;i++) {
    cout<<res[i]<<" ";
  }
  return 0;
}