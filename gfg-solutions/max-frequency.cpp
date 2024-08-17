// Question Link : https://www.geeksforgeeks.org/problems/maximum-frequency-1662528911/1

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int maxFrequency(int arr[], int n, int k) {
        // Code here
        sort(arr, arr + n, greater<int>());
        
        int i = 0, j = 0, freq = 1, maxFreq = 1;
        
        int numOps = k;
        
        while (i <= j && j <= n-1)
        {
         // cout << "i=" << i << ", " << "j=" << j << ", " << "arr[i]=" << arr[i] << ", " << "arr[j]=" << arr[j] << ", " << "freq=" << freq << ", " << "maxFreq=" << maxFreq << ", " << "numOps=" << numOps << endl;
            if (i == j)
            {
                j++;
            }
            else if ((arr[j] + numOps) >= arr[i])
            {
                freq++;
                
                if (freq > maxFreq)
                {
                    maxFreq = freq;
                }
                
                numOps = (arr[j] + numOps) - arr[i];
                
                if (numOps == 0)
                {
                    i++;
                    j = i;
                    freq = 1;
                    numOps = k;
                }
                else
                {
                    j++;
                }
            }
            else
            {
                i++;
                
                j = i;
                
                freq = 1;
                
                numOps = k;
                //   cout<<endl;
            }
        }
        
        return maxFreq;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t; // testcases
    while (t--) {
        int n, k;
        cin >> n >> k; // total size of array and integer k

        int arr[n];

        // inserting elements in the array
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution obj;
        // calling maxFrquency() function
        int ans = obj.maxFrequency(arr, n, k);

        cout << ans << endl;
    }
}
// } Driver Code Ends
