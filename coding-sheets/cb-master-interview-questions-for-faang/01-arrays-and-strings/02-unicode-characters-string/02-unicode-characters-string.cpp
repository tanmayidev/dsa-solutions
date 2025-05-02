#include <bits/stdc++.h>
using namespace std;
#define li long long int
bool check(string s){
//checks if all character are unique or not.
set<char> a;
for(auto i : s){
if(a.count(i))
return false;
a.insert(i);
}
return true;
}

vector<string> helper(vector<string>& arr, int ind){
//base case when we reach end of array
if(ind == arr.size())
return {""};

//To try every string as a starting string and store its result.

vector<string> tmp = helper(arr, ind+1);

vector<string> ret(tmp.begin(), tmp.end());
//add current string to result of other string and
//check if characters are unique after adding
for(auto i : tmp){
string test = i+arr[ind];
if(check(test))
ret.push_back(test);
}
return ret;
}

int maxLength(vector<string>& arr) {
vector<string> tmp = helper(arr, 0);
int len = 0;
//return max length possible.
for(auto i : tmp){
len = len > i.size() ? len : i.size();
}
return len;
}

int main(){
//driver code
int n;
cin>>n;
vector<string>v;
for(int i=0;i<n;i++){

string s;
cin>>s;
v.push_back(s);
}

cout << maxLength(v) << endl;
}