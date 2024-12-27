import java.util.Scanner;

public class Main {
	public static Scanner reader = new Scanner (System.in);
    public static void main(String[] args) {
        int[] arr = {1,3,2,3,5,4};
        Node<Integer> head = buildList(arr);
        int[] arr1 = {1, 2, 3, 4, 6};
        Node<Integer> head2 = buildList(arr1);
        //Node<Integer> head3 = sortList(head);
        //System.out.println(head3);
        //boolean result=unique(head);
       // System.out.println(result);
        Node<Integer> result1 = nodoubles(head);
        System.out.println(result1);
    }
    public static Node<Integer> buildList(int[] a) { // ex1
        Node<Integer> head = new Node<>(a[0]);
        Node<Integer> curr = head;
        for (int i = 1; i < a.length; i++) {
            Node<Integer> next = new Node<>(a[i]);
            curr.setNext(next);
            curr = next;
        }
        return head;
    }
    public static Node<Integer> MergeLists(Node<Integer> head, Node<Integer> head2){//ex1			
    	Node<Integer> mergedHead = new Node<>(null);
        Node<Integer> temp = mergedHead;

        while (head != null && head2 != null) {
            if (head.getValue() < head2.getValue()) {
                temp.setNext(head);
                head = head.getNext();
            } else if (head.getValue() > head2.getValue()) {
                temp.setNext(head2);
                head2 = head2.getNext();
            } else {
                temp.setNext(head);
                head = head.getNext();
                head2 = head2.getNext();
            }
            temp = temp.getNext();
        }

        if (head != null) {
            temp.setNext(head);
        } else if (head2 != null) {
            temp.setNext(head2);
        }

        return mergedHead.getNext();	
    }
    public static Node<Integer> sortList(Node<Integer> head){// ex2
    	if (head==null || head.getNext()==null)
    		return head;
    	Node <Integer>current =head;
    	Node <Integer> index=null;
    	int temp;
    	while (current != null) {
    		index = current.getNext();
    		while (index!= null) {
    			if (current.getValue() > index.getValue()) {
    				temp = current.getValue();
    				current.setValue(index.getValue());
    				index.setValue(temp);
    			}
    			index = index.getNext();
    			
    		}
    		current= current.getNext();
    	}
    	return head;
    }
    
    public static int Distances1(Node<Integer> head, int num) {
    	int dfs = 0;
    	int dfe = 0;
    	Node <Integer> current = head;
    	while (current.getValue()!=num){
    		dfs++;
    		current=current.getNext();
    	}
    	current=current.getNext();
    	while (current!=null) {
    		if (current.getValue()==num) 
    			dfe=0;
    		else 
    			dfe++;
    		current=current.getNext();
    	} 
    	return dfs + dfe;
    }
    
	public static boolean unique(Node<Integer> head) {
		Node <Integer> current = sortList(head);
		while (current.hasNext()) {
			if (current.getValue()== current.getNext().getValue())
				return false;
			current = current.getNext();
		}
		return true;
			
	}
	public static Node<Integer> nodoubles(Node<Integer> head){
		Node<Integer> dummy = new Node<Integer> (-1);
		Node<Integer> dummy2 =dummy; 
		Node <Integer> current = head;
		
		while(current!=null)
		{
			if (!ifinList(dummy, current.getValue())){
				dummy.setNext(new Node<Integer>(current.getValue()));
				dummy =dummy.getNext();
			}
			current=current.getNext();
		}
		return dummy;
	}
	 public static boolean ifinList (Node <Integer> head , int x) {//ex5
	    	while(head!=null){
	    		if (head.getValue()==x)
	    			return true;
	    		head= head.getNext();
	    	} 
	    	return false;
	    
	    }
 }