public class q1 {
    class Node {
        String item;
        Node next;
    }

    private static Node head = null;

    public void mystery() {
        Node p = head;
        Node q = null;
        Node r;
        while (p != null) {
            r = p;
            p = p.next;
            r.next = q;
            q = r;
        }
        head = q;
    }
    /*
    The mystery() method reverses the order of the nodes in the linked list.
    After calling this method, the linked list will have its elements in reverse
    order compared to their original arrangement.
    */ 

    
    
}
