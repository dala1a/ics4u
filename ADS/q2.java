/* Suppose that items in a linked list are in non-decreasing order. 
Write an instance method 'simplify' that deletes any duplicate entries 
from a list. If, for example, before calling 'simplify,' a list contains:
2 3 3 3 5 8 8 9

Then, after 'simplify' has been called, the list should contain:

2 3 5 8 9

 */
public class q2 {
    class IntNode {
        int item;
        IntNode next;
    }
    private static IntNode head;

    public static void simplify() {
        IntNode current = head;
        while (current != null && current.next != null) { //go thru list
            if (current.item == current.next.item) {
                current.next = current.next.next;
            }
            current = current.next;
        }
    }

    public static void print() {
        IntNode current = head;
        while (current.next != null) {
            System.out.print(current.item+ "\t");
            current = current.next;
        }
    }

    public static void add(int newItem) {
        if (head == null) {
            IntNode tempNode = new IntNode();
            tempNode.item = newItem;
            tempNode.next = null;
            head = tempNode;
            return;
        }
            IntNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            IntNode tempNode = new IntNode();
            tempNode.item = newItem;
            tempNode.next = null;
            current.next = tempNode;
          
    }

    public static void main(String[] args) {
        add(1);
        
    }
}
