#include <bits/stdc++.h>
using namespace std;

//Your function receives the array for each testcase as input.
//Return a valid pancake sort configuration for this testcase.
//Note that this function is called  testcase.
vector<int> pancakeSorting(vector<int> &a) {
//Complete this function
}
/*

You do need to concern yourself with the code below.
You do not even need to see it or know.
Just complete the function definition above.

*/

bool __checkSorted(const vector<int> &tmp) {
for (int i = 0; i < tmp.size() - 1; ++i) {
if (tmp[i] > tmp[i + 1])
return false;
}
return true;
}

void __flip(vector<int> &tmp, int k) {
for (int i = 0; i < k / 2; ++i) {
swap(tmp[i], tmp[k - i - 1]);
}
}

int main() {
int testCases;
cin >> testCases;
while (testCases--) {
int n;
cin >> n;

vector<int> arr(n), tmp(n);
for (int i = 0; i < n; ++i) {
cin >> arr[i];
tmp[i] = arr[i];
}
vector<int> v = pancakeSorting(arr);
for (int i = 0; i < v.size(); ++i) {
__flip(tmp, v[i]);
}

bool isSorted = __checkSorted(tmp);
if (isSorted) {
cout << "Valid pancake sort";
}
else {
cout << "Incorrect pancake sort";
}
cout << endl;
}
return 0;
}