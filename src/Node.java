 class Node {
    int val;
    Node next;
    Node prev;
    public Node(int d){
        val = d;
        next = null;
        prev = null;
    }
}

class Test{
    public  static void main(String args[]){
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        head.next = temp1;
        temp1.prev = head;
        temp1.next = temp2;
        temp2.prev = temp1;

        printList(head);

        System.out.println("after insertion ");
        head = insertAtFirst(head,40);
        printList(head);
        System.out.println("delete first node");
        head = deleteFirst(head);
        printList(head);
        System.out.println("delete last node");
        head = deleteLast(head);
        printList(head);
        System.out.println("insert at last of the node");
        head = insertAtLast(head,50);
        printList(head);

        System.out.println("print reverse");
        printList(reverseDll(head));



    }
    static Node insertAtFirst(Node head, int val){
        Node temp = new Node(val);
        temp.next =head;
        if(head != null){
            head.prev = temp;

        }
        return temp;
    }
    static Node reverseDll(Node head){
        if(head == null || head.next == null) return head;
        Node prev = null;
        Node curr =head;
        while(curr != null){
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;
            curr = curr.prev;
        }
        return prev.prev;


    }
    static Node deleteFirst(Node head){
        if(head ==null){
            return null;
        }
        if(head.next == null){
            return null;
        }
        else{
            head= head.next;
            head.prev = null;
            return head;
        }

    }
    static Node deleteLast(Node head){
        if(head == null){
            return null;
        }
        if(head.next == null) {
            return null;
        }
        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.prev.next =null;

        return head;
    }
    static Node insertAtLast(Node head,int val){
        Node temp = new Node(val);
        if(head == null) return temp;
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = temp;
        temp.prev = curr;
        return head;

    }
    public static void printList(Node head){
        Node curr =head;
        while(curr != null){
            System.out.print(curr.val+ " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
