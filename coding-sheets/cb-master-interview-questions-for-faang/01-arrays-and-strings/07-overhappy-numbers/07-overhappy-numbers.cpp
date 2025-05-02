#include
#include
using namespace std;
// LEETCODE FUNCTION
// COPY AND PASTE THIS THERE
int cal(int a)
{
  int ans=0;
  while(a)
  {
    int d = a%10;
    ans += d*d;
    a/=10;
  }
  return ans;
}

bool isHappy(int n) {
  unordered_map mp;
  int a = n;
  
    while(mp.find(a) == mp.end())
    {
      mp[a]=true;
      a = cal(a);
      if(a==1)
        return true;
    }
    return false;
}

int main() {
  int n;
  cin>>n;
  
  if(isHappy(n))
    cout<<"true";
  else
    cout<<"false";
}