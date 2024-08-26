#include <bits/stdc++.h>
using namespace std;
int distributeCandies(vector<int>& candies) {
unordered_map<int,int>m;
int count=0;
for(int i=0;i<candies.size();i++)
{
if(m.find(candies[i])==m.end())
{
m.insert({candies[i],1});
count++;
}
else
m[candies[i]]++;
}
int ans=count<candies.size()/2?count:candies.size()/2;
return ans;
}
int main() {

int n;
cin>>n;
vector<int>arr;
int a;
for(int i=0;i<n;i++)
{
cin>>a;
arr.push_back(a);
}
cout<<distributeCandies(arr);
}