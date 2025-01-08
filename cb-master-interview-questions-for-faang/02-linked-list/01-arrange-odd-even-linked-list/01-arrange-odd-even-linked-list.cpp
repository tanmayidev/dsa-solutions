#include <iostream>
using namespace std;

class ListNode {
  public:
    int val;
    ListNode* next;

    ListNode(int val) {
      this->val = val;
      next = NULL;
    }
};

ListNode* createList(int num) {
  if(num == 0) 
    return NULL;
  
  int a; 
  cin >> a;
    
  ListNode* n = new ListNode(a);
  n->next = createList(num-1);
    
  return n;
}

void printList(ListNode* head) {
  if(head == NULL) 
    return;
  
  cout << head->val << ' ';
  printList(head->next);
  return;
}

  // Definition of a node of LinkedList
  // class ListNode{
  // public:
  // int val;
  // ListNode* next;
  // ListNode(int val){
  // this->val = val;
  // next = NULL;
  // }
  // };

ListNode* oddEvenList(ListNode* head) {

  if(head == NULL) 
    return NULL;
  
  ListNode* odd_head = NULL;
  ListNode* odd_tail = NULL;
  ListNode* even_head = NULL;
  ListNode* even_tail = NULL;
  ListNode* temp = head;
  
  bool is_odd = 1;
  
  while(temp != NULL) {
    if(is_odd) {
      if(odd_head == NULL) {
        odd_head = odd_tail = temp;
      }
      else {
        odd_tail->next = temp;
        odd_tail = temp;
      }
      temp = temp->next;
      odd_tail->next = NULL;
    }
    else {
      if(even_head == NULL) {
        even_head = even_tail = temp;
      }
      else {
        even_tail->next = temp;
        even_tail = temp;
      }
      temp = temp->next;
      even_tail->next = NULL;
    }
    
    is_odd = !is_odd;
  }
  
  odd_tail->next = even_head;
  return odd_head;
}

int main() {
  int n; cin>>n;
  
  ListNode* head = createList(n);
  cout<<"Original List: ";
  printList(head); cout<<endl;

  cout<<"Modified List: ";
  printList(oddEvenList(head));
  cout<<endl;
  return 0;
}