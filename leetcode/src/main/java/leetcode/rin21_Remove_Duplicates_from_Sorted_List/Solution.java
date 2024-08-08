package leetcode.rin21_Remove_Duplicates_from_Sorted_List;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    // Phương thức chính để xóa các phần tử trùng lặp
    public ListNode removeDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        // Sắp xếp danh sách liên kết
        head = sortList(head);

        // Xóa các phần tử trùng lặp từ danh sách đã sắp xếp
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next; // Bỏ qua phần tử trùng lặp
            } else {
                cur = cur.next; // Di chuyển con trỏ hiện tại
            }
        }

        return head;
    }

    // Phương thức in danh sách liên kết
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Hàm chính để sắp xếp danh sách liên kết
    private ListNode sortList(ListNode head) {
        // Trường hợp cơ bản: danh sách rỗng hoặc chỉ có một phần tử
        if (head == null || head.next == null) {
            return head;
        }

        // Tìm điểm giữa của danh sách
        ListNode middle = getMiddle(head);
        ListNode nextOfMiddle = middle.next;

        // Ngắt danh sách tại điểm giữa
        middle.next = null;

        // Sắp xếp hai nửa
        ListNode left = sortList(head);
        ListNode right = sortList(nextOfMiddle);

        // Hợp nhất hai nửa đã sắp xếp
        return mergeSortedLists(left, right);
    }

    // Hàm để tìm điểm giữa của danh sách
    private ListNode getMiddle(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Hàm để hợp nhất hai danh sách đã sắp xếp
    private ListNode mergeSortedLists(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        // Gắn nốt các phần tử còn lại của hai danh sách
        if (left != null) {
            tail.next = left;
        } else {
            tail.next = right;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Tạo danh sách liên kết ví dụ
        ListNode head = new ListNode(4);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(2);

        // In danh sách ban đầu
        System.out.print("Original list: ");
        solution.printList(head);

        // Xóa các phần tử trùng lặp
        ListNode newHead = solution.removeDuplicates(head);

        // In danh sách sau khi xóa các phần tử trùng lặp
        System.out.print("List after removing duplicates: ");
        solution.printList(newHead);
    }
}
