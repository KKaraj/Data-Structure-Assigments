class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class AddTwoNumbers {
    //method to add two numbers represented by linked lists
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // dummy head node
        ListNode current = dummyHead;
        int carry = 0;

        //traverse both lists
        while (l1 != null || l2 != null || carry != 0) {
            int value1 = (l1 != null) ? l1.val : 0;
            int value2 = (l2 != null) ? l2.val : 0;

            int sum = value1 + value2 + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10); //add new digit node
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummyHead.next;
    }
    //helper method to build a linked list from an array
    public static ListNode buildList(int[] digits) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : digits) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

 
    public static void main(String[] args) {
        AddTwoNumbers solver = new AddTwoNumbers();

        ListNode l1 = buildList(new int[]{2, 4, 3}); // represents 342
        ListNode l2 = buildList(new int[]{5, 6, 4}); // represents 465

        System.out.print("Input L1: ");
        printList(l1);
        System.out.print("Input L2: ");
        printList(l2);

        ListNode result = solver.addTwoNumbers(l1, l2); // expected: 7 -> 0 -> 8

        System.out.print("Output : ");
        printList(result);
    }
}
