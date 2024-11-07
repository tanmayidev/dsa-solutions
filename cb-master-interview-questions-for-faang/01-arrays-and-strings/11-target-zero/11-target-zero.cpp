#include <bits/stdc++.h>
using namespace std;
vector<int> sumZero(int n) {
int num = n/2;
vector<int>ans;
for(int i=1;i<=num;i++){
ans.push_back((-1*i));
ans.push_back(i);
}
if(n%2)
ans.push_back(0);
return ans;
}
void print(vector<int>v){
sort(v.begin(), v.end());
for(int i=0;i<v.size();i++){
cout<<v[i]<<" ";
}
return ;
}
int main() {
// cout<<"Hello World!";
int n;
cin>>n;
vector<int>ans = sumZero(n);
//Multiple possible answers
print(ans);
return 0;
}