//Input Format
//1. n (size of array)
//2. elements of array
#include <bits/stdc++.h>
using namespace std;
void moveZeroes(vector<int>& nums) {
int l=0,m=0;
while(m<nums.size())
{
switch(nums[m])
{
case 0:
m++;
break;
default:
swap(nums[l++],nums[m++]);

break;

}
}
for(int i=0;i<nums.size();i++){
cout<<nums[i]<<" ";
}

}
int main() {
int n;
cin>>n;
vector<int> nums;
for(int i=0;i<n;i++){
int c;
cin>>c;
nums.push_back(c);
}
moveZeroes(nums);
}