#include <bits/stdc++.h>
using namespace std;
int first_index(vector<int>v,int key) {
  int s = 0;
  int e = v.size() - 1;
  int a = INT_MAX;

  while(s<=e) {
    int mid = (s+e)/2;

    if(v[mid]==key) {
      a = min(a,mid);
      e = mid - 1;
    }
    else if(v[mid]>key) {
      e = mid - 1;
    }
    else {
      s = mid + 1;
    }
  }

  if(a==INT_MAX)
    a=-1;
  
  return a;
}

int last_index(vector<int>v,int key){
  int s = 0;

  int e = v.size() - 1;
  int a = INT_MIN;

  while(s<=e) {
    int mid = (s+e)/2;

    if(v[mid]==key) {
      a = max(a,mid);
      s = mid + 1;
    }
    else if(v[mid]>key) {
      e = mid - 1;
    }
    else  {
      s = mid + 1;
    }
  }

  if(a==INT_MIN)
    a=-1;
  
  return a;
}

vector<int> searchRange(vector<int>& nums, int target) {
  int n = nums.size();
  int ans1 = first_index(nums,target);
  int ans2 = last_index(nums,target);
 
  vector<int>v;
  v.push_back(ans1);
  v.push_back(ans2);
 
  return v;
}

int main() {
  int n,d,key;
  cin>>n;

  vector<int>v;
  
  for(int i=0;i<n;i++) {
    cin>>d;
    v.push_back(d);
  }
  cin>>key;

  vector<int>ans = searchRange(v,key);
  cout<<ans[0]<<" "<<ans[1]<<endl;
  
  return 0;
}