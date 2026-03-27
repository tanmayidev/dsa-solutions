static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {

    // Create new node
    SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

    // Point new node to current head
    newNode.next = llist;

    // Return new node as new head
    return newNode;
}