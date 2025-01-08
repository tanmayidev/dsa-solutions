#include<bits/stdc++.h>
using namespace std;


int threeSumClosest(vector<int>& num, int target) {
  sort(num.begin(),num.end());
  
  int closeDiff=INT_MAX;
  int close_sum;
  
  for(int i = 0; i < num.size()-2; i++)
  {
    int sum=0;
    sum+=num[i];
  
    int j=i+1,k=num.size()-1;
    sum+=num[j]+num[k];
  
    while(j < k)
    {
      if(abs(sum-target) < closeDiff)
      {
        closeDiff = abs(sum-target);
        close_sum = sum;
      }
      if(sum < target)
      {
        sum -= num[j];
        j++;
        sum += num[j];
      }
      else if(sum > target)
      {
        sum -= num[k];
        k--;
        sum += num[k];
      }
      else
      {
        break;
      }
    }
  }
  return close_sum;
}


int main()
{
  int n;
  cin>>n;

  int target;
  cin>>target;
  
  vector<int>num;
  int a;
  
  for(int i=0;i<n;i++)
  {
    cin>>a;
    num.push_back(a);
  }
  cout<<threeSumClosest(num,target);
}