public class LinkedList{
    public Node head;
    
    
    /* First Constructor:
     * Creates a linked list using the values from the given array. head will refer
     * to the Node that contains the element from a[0]
     */ 
    public LinkedList(Object [] a){
        Node n = new Node(a[0], null);
        head = n;
        Node tail = n;
        
        for(int i = 1; i < a.length; i++){
            Node node = new Node(a[i], null);
            tail.next = node;
            tail = tail.next;
        }
        
    }
    
    
    
    /* Second Constructor:
     * Sets the value of head. head will refer
     * to the given LinkedList
     */
    public LinkedList(Node h){
        head = h;
    }
    
    /* Counts the number of Nodes in the list */
    public int countNode(){
        int count = 0;
        
        for(Node n = head; n != null; n = n.next){
            count++;
        }
        return count; 
    }
    
    /* prints the elements in the list */
    public void printList(){
        for(Node n = head; n != null; n = n.next){
            System.out.print(n.element+" ");
        }
        System.out.println();
    }
    
   // returns the reference of the Node at the given index. For invalid index return null.
     public Node nodeAt(int idx){
         try{
             if(idx < 0 || idx > countNode()){
                 throw new NullPointerException();
             }
         }
         catch(NullPointerException e){
             System.out.println("Invalid index");
         }
         int i = 0;
         for(Node n = head; n != null; n = n.next){
             if(i == idx){
                 return n;
             }
             else{
                 i++;
             }
         }
         return null;
    }
    
    
// returns the element of the Node at the given index. For invalid idx return null.
    public Object get(int idx){
        try{
             if(idx < 0 || idx > countNode()){
                 throw new NullPointerException();
             }
         }
         catch(NullPointerException e){
             System.out.println("Invalid index");
         }
         
         Node n = nodeAt(idx);
         if(n == null){
             return null;
         }
         else{
             return n.element;
         }
        
    }
    
    
    
    /* updates the element of the Node at the given index. 
     * Returns the old element that was replaced. For invalid index return null.
     * parameter: index, new element
     */
    public Object set(int idx, Object elem){
        if(idx < 0 || idx > countNode()){
            return null;
        }
         Node n = nodeAt(idx);
         if(n == null){
             return null;
         }
         else{
             Object temp = n.element;
             n.element = elem;
             return temp;
         }
         
        
    }
    
    
    /* returns the index of the Node containing the given element.
     if the element does not exist in the List, return -1.
     */
    public int indexOf(Object elem){
        int i = 0;
        for(Node n = head; n != null; n = n.next){
            if(n.element.equals(elem)){
                return i;
            }else{
                i++;
            }
        }
        return -100; // please remove this line!
    }
    
    // returns true if the element exists in the List, return false otherwise.
    public boolean contains(Object elem){
        for(Node n = head; n != null; n = n.next){
            if(n.element.equals(elem)){
                return true;
            }
        }
        return false; // please remove this line!   
    }
    
    // Makes a duplicate copy of the given List. Returns the reference of the duplicate list.
    public Node copyList(){
        
        Node copyHead = new Node(head.element, null);
        Node copyTail = copyHead;
        for(Node n = head.next; n != null; n = n.next){
            Node mn = new Node(n.element, null);
            copyTail.next = mn;
            copyTail = mn;
        }
        return copyHead;
    }
    
    // Makes a reversed copy of the given List. Returns the head reference of the reversed list.
    public Node reverseList(){
        Node revHead = new Node(head.element, null);
        for(Node n = head.next; n != null; n = n.next){
            Node temp = new Node(n.element, null);
            temp.next = revHead;
            revHead = temp;
        }
        return revHead;
    }
    
    /* inserts Node containing the given element at the given index
     * Check validity of index.
     */
    public void insert(Object elem, int idx){
        if(idx < 0 || idx > countNode()){
            System.out.println("Invalid index");
        }
        else{
            Node mn = new Node(elem, null);
            if(idx == 0){
                mn.next = head;
                head = mn;
            }
            else{
                Node pred = nodeAt(idx - 1);
                mn.next = pred.next;
                pred.next = mn;
            }
        }
    }
    
    
    /* removes Node at the given index. returns element of the removed node.
     * Check validity of index. return null if index is invalid.
     */
    public Object remove(int index){
        if(index < 0 || index > countNode()){
            System.out.println("Invalid index");
            return null;
        }
        else{
            if(index == 0){
                Node removedNode = head;
                Object removedElement = head.element;
                
                head = head.next;
                removedNode.next = null;
                removedNode.element = null;
                return removedElement;
            }
            else{
                Node pred = nodeAt(index - 1);
                Node removedNode = pred.next;
                Object removedElement = pred.next.element;
                pred.next = pred.next.next;
                removedNode.element = null;
                removedNode.next = null;
                return removedElement;
            }
        }
        
    }
    
    // Rotates the list to the left by 1 position.
    public void rotateLeft(){
        Node temp = head;
        head = head.next;
        temp.next = null;
        
        Node n;
        for(n = head; n.next != null; n = n.next){
        }
        n.next = temp;
    }
    
    // Rotates the list to the right by 1 position.
    public void rotateRight(){
        Node n = head;
        for(int i = 1; i < (countNode()-1); i++){
            n = n.next;
        }
        
        Node temp = n.next;
        n.next = null;
        temp.next = head;
        head = temp;
    }
    
}