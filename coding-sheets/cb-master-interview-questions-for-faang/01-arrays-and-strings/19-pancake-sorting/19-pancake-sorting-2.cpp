#include <bits/stdc++.h>
using namespace std;

int find(const vector<int> &a, int x)
{
for (int i = 0; i < a.size(); i++)
if (a[i] == x)
return i;
return -1;
}
void flip(vector<int> &a, int k)
{
for (int i = 0; i < k / 2; i++)
{
int t = a[i];
a[i] = a[k - i - 1];
a[k - i - 1] = t;
}
}

vector<int> pancakeSorting(vector<int> &a) {
int n = a.size();
vector<int> ans;
while (n > 0)
{
int i = find(a, n);
if (i != n - 1)
{
flip(a, i + 1);
flip(a, n);
ans.push_back(i + 1);
ans.push_back(n);
}
n--;
}

return ans;
}