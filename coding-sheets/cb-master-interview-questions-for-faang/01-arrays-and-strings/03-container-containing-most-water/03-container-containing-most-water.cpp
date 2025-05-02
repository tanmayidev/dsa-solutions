#include<iostream>
#include<vector>
using namespace std;
int maxArea(vector<int>& height) {
int n=height.size()-1;
int i=0;
int ans=0;
while(i<n){
ans=max(ans,(n-i)*min(height[i],height[n]));
if(height[i]<height[n]){
i++;
}else{
n--;
}
}
return ans;
}
int main(){
int n,temp;

cin>>n;
vector<int> v;
for(int i=0;i<n;i++){
cin>>temp;
v.push_back(temp);
}
int x=maxArea(v);
cout << x<<endl;
return 0;
}