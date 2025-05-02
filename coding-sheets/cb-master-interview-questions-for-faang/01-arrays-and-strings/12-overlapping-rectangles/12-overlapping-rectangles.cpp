#include <iostream>

using namespace std;

bool isOverLap(int rec1[], int rec2[]) {
  return !(rec1[2] <= rec2[0] ||
    rec1[3] <= rec2[1] ||
    rec1[0] >= rec2[2] ||
    rec1[1] >= rec2[3]);

}


int main() {
  int rec1[4];
  int rec2[4];
  
  for(int i = 0; i < 4; i++) {
    cin >> rec1[i];
  }
  
  for(int i = 0; i < 4; i++) {
    cin >> rec2[i];
  }

  cout << isOverLap(rec1, rec2);
}