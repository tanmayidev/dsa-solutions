//Input size of array
//Input array and target
#include <bits/stdc++.h>
using namespace std;
int search(vector<int>& nums, int target) {
int n=nums.size();
int l=0,r=n-1;
while(l<=r){
int mid=(l+r)/2;
if(nums[mid]==target){
return mid;
}
else if(nums[mid]>nums[n-1]){
if(target<nums[0] || target>nums[mid]){
l=mid+1;
}
else{
r=mid-1;
}
}
else{
if(target>nums[n-1] || target<nums[mid]){
r=mid-1;
}
else{
l=mid+1;
}
}
}
return -1;
}

int main() {
int n,target;
cin>>n;
vector<int> nums;
for(int i=0;i<n;i++){
int num;
cin>>num;
nums.push_back(num);
}
cin>>target;
cout<<search(nums,target);
return 0;
}