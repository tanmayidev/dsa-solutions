#include<bits/stdc++.h>
using namespace std;

bool isValidSudoku(vector<vector<char>>& b)
{
  vector<int> temp(10, 1);
  vector<vector<int>> block(9, temp);
  vector<vector<int>> row(9, temp);
  vector<vector<int>> col(9, temp);
  
  int i, j, t;
  
  for (i = 0; i < 9; ++i)
  {
    for (j = 0; j < 9; ++j)
    {
      if ('.' == b[i][j])
        continue;
      
      t = b[i][j] - 48;
      
      if (row[i][t] && col[j][t] && block[(i / 3) * 3 + j / 3][t])
        row[i][t] = col[j][t] = block[(i / 3) * 3 + j / 3][t] = 0;
      else
        return 0;
    }
  }
  return 1;
}


int main() {

  vector<vector<char>> matrix(9,vector<char> (9));

  for(int i=0;i<9;i++)
  {
    for(int j=0;j<9;j++)
    {
      cin>>matrix[i][j];
    }
  }
  
  cout<<std::boolalpha<<isValidSudoku(matrix);
  
  return 0;
}