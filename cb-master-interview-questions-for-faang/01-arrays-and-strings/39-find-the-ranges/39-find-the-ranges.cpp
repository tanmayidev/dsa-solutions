#include <bits/stdc++.h>

using namespace std;

string inttostring(int n){
  string s="";
 
  if(n==0) {
    s+='0';
    return s;
  }
  
  while(n>0) {
    int x=n%10;
    s+=x+'0';
    n=n/10;
  }
  
  int start =0;
  int end =s.length()-1;
  
  while(start<end) {
    char c=s[start];
    s[start] = s[end];
    s[end] =c;
    start++;
    end--;
  }
  return s;
}

vector<string> summaryRanges(vector<int>& nums) {
  int n=nums.size();
  vector<string> ans;
  int i=0;
  
  while(i<n) {
    string temp="";
    temp+=inttostring(nums[i]);
    int num=nums[i];
   
    while(i+1<n && nums[i+1]==nums[i]+1) {
      i++;
    }
    
    if(nums[i]!=num) {
      temp+="->";
      temp+=inttostring(nums[i]);
    }
    ans.push_back(temp);
    i++;
  }
  return ans;
}


int main() {
  int n;
  cin>>n;
  vector<int> nums;
  
  for(int i=0;i<n;i++) {
    int num;
    cin>>num;
    nums.push_back(num);
  }
  vector<string> ans=summaryRanges(nums);

  for(int i=0;i<ans.size();i++) {
    cout<<ans[i]<<" ";
  }
  return 0;
}