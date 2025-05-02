#include<bits/stdc++.h>
using namespace std;

int findMin(vector<int>& nums) {
  int n=nums.size();
  int l=0,r=n-1;

  if(nums[l]<=nums[r]){
    return nums[l];
  }

  while(l<=r) {
    int mid=(l+r)/2;

    if(mid-1>=0 && nums[mid]<nums[mid-1]) {
      return nums[mid];
    }
    else if(nums[mid]>nums[n-1]) {
      l=mid+1;
    }
    else{
      r=mid-1;
    }
  }
    
  return -1;
}

int main() {
  int n;
  cin>>n;
  
  vector<int> nums;
  
  for(int i=0;i<n;i++){
    int num;
    cin>>num;
    nums.push_back(num);
  }
  
  cout<<findMin(nums);
}