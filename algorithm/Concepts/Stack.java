// Stack collection java
Stack<Integer> stack = new Stack<Integer>();
stack.push(23);
Integer result = (Integer) stack.pop();  //remove and return the top of the stack
Integer result = (Integer) stack.peek();  // return the top of the stack not remove it
boolean result = stack.empty();   // check whether the stack is empty
int position = stack.search(34);  // return the zero-based position of the elemnt

// Queue collections java
Queue<Integer> q = new LinkedList<Integer>();
Queue<Integer> queueB = new PriorityQueue<Integer>();
queueB.add(45);  queueB.offer(45);
queueB.remove();  queueB.poll();   //return and remove the head of the queue or null if empty
queueB.element();   // return the head of the queue but not remove it return error if empty
queueB.peek();   //return the head of the queue but not remove it return null if empty


class StudentComparator implements Comparator<Student>{ 
              
	// Overriding compare()method of Comparator  
	// for descending order of cgpa 
	public int compare(Student s1, Student s2) { 
	    if (s1.cgpa < s2.cgpa) 
	        return 1; 
	    else if (s1.cgpa > s2.cgpa) 
	        return -1; 
	    return 0;
	}
}
// PriorityQueue Queue collections with natural ordering/priority heap
PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
PriorityQueue<Student> pstuQueue = new PriorityQueue<Student>(5, new StudentComparator());
pQueue.add(3);
pQueue.poll();
pQueue.size();
pQueue.peek();
pQueue.contains(3);
pQueue.remove(3);
boolean result = pQueue.contains(23);
int[] result = pQueue.toArray();
Comparator result = pQueue.comparator();



class Hanio{
	public void moveOne(int n, String init, String desti){    //只有一个盘子的情况		
		System.out.println(" move:"+n+" from "+init+" to "+desti);	
	}	
	public void move(int n, String init, String temp, String desti){		
		if(n <= 0){			
			System.out.println("number error");			
			return;		
		}		
		else if(n == 1){			
			moveOne(n,init,desti);		
		} 
		else{			
			move(n-1, init, desti, temp);//首先将上面的（n-1）个盘子从init杆借助desti杆移至temp杆  			
			moveOne(n, init, desti);     //然后将编号为n的盘子从init杆移至desti杆  			
			move(n-1, temp, init, desti);//最后将上面的（n-1）个盘子从temp杆借助init杆移至desti杆   		
		}	
	}
}

class HanioApp{
	public static void main(String args[]){
		Hanio hanio = new Hanio();
		hanio.move(3, "A", "B", "C");
	}
}

public static Stack<Integer> sort(Stack<Integer> s) {
	Stack<Integer> r = new Stack<Integer>();
	while(!s.isEmpty()) {
		int tmp = s.pop();
		while(!r.isEmpty() && r.peek() > tmp) {
			s.push(r.pop());
		}
		r.push(tmp);
	}
	return r;
}

// Tree and Graph BFS and DFS
// https://algorithms.tutorialhorizon.com/breadth-first-searchtraversal-in-a-binary-tree/
// https://algorithms.tutorialhorizon.com/tree-traversals/
// https://algorithms.tutorialhorizon.com//depth-first-searchtraversal-in-binary-tree/

