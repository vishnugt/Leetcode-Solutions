class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        List<Integer> numbersPresentOnce = new ArrayList<Integer>();
        Set<Integer> duplicates = new HashSet<Integer>();
        
        ListNode iter = head;
        while(iter!=null){
            Integer value = iter.val;
            if(numbersPresentOnce.contains(value)) {
                numbersPresentOnce.remove(value);
                duplicates.add(value);
            }
            else numbersPresentOnce.add(value);
            iter = iter.next;
        }
        
        while(true && head!=null){
            if(duplicates.contains(head.val))
                head=head.next;
            else break;
        }
        
        ListNode headToReturn = head;
        iter = head;
        while(iter!=null && iter.next!=null)
            if(duplicates.contains(iter.next.val)){
                ListNode temp = iter;
                iter.next = iter.next.next;
            }
            else{
                iter = iter.next;
            }
            
        
        return headToReturn;
        
    }
}