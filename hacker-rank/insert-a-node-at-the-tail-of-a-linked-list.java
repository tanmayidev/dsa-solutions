static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
    
    // Step 1: Create new node
    SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
    
    // Step 2: If list is empty
    if (head == null) {
        return newNode;
    }
    
    // Step 3: Traverse to the end
    SinglyLinkedListNode current = head;
    while (current.next != null) {
        current = current.next;
    }
    
    // Step 4: Insert at tail
    current.next = newNode;
    
    return head;
}