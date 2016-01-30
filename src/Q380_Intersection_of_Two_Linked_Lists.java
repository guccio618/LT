
public class Q380_Intersection_of_Two_Linked_Lists {
	// by ninechapter
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        } 
        ListNode node = headA;
        while(node.next != null){
            node = node.next;
        }
        node.next = headB;
        
        ListNode faster = headA.next, slower = headA;
        
        while(faster != slower){
            if(faster == null || faster.next == null){
                return null;
            }
            faster = faster.next.next;
            slower = slower.next;
        }
        
        while(headA != slower.next){
            headA = headA.next;
            slower = slower.next;
        }
        return headA;
    }
}
