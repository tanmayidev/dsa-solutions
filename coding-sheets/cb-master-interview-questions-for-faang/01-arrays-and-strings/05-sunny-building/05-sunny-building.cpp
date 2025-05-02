#include<iostream>
using namespace std;
int main() {
int t;
cin>>t;
while(t--){
int n,cur_max=INT_MIN,res=0;
cin>>n;
for(int i=0;i<n;i++){
int num;
cin>>num;
if(num>=cur_max){
res++;
cur_max=num;
}
}
cout<<res<<endl;
}
return 0;
}