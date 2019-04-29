package topologicalsort;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DirectedGraph {

	LinkedList<Integer>[] adjList;
	int vertices;
	
	public DirectedGraph(int vertices) {
		this.vertices= vertices;
		adjList= new LinkedList[vertices];
		for(int i=0;i<vertices;i++) {
			adjList[i]= new LinkedList<>();
		}
	}
	
	public void addEdge(int i,int j) {
		adjList[i].add(j);
	}

	private void show() {
		for(int i=0;i<adjList.length;i++) {
			 System.out.print(i+":");
			for(int j=0;j<adjList[i].size();j++) {
				System.out.print(adjList[i].get(j)+"->");
			}
			System.out.println();
		}
		
	}
	public static void main(String [] arr) {
		DirectedGraph adjlist = new DirectedGraph(4);
		adjlist.addEdge(0, 1);
		adjlist.addEdge(1, 3);
		adjlist.addEdge(2, 3);

		adjlist.show();
	
		adjlist.dfs();
	}

	private void dfs() {
		// TODO Auto-generated method stub
		boolean [] visited = new boolean[vertices];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<vertices; i++) {
			if(!visited[i])
				dfsutil(i, visited,stack) ;
		}
		System.out.println();
		for(int a : stack) {
			System.out.print(a+ " ");
		}
	}

	private void dfsutil(int s, boolean [] visited,Stack<Integer> stack ) {
		// TODO Auto-generated method stub
		visited[s]=true;
		System.out.print(s+ " ");
		for(int i : adjList[s]) {
			if(!visited[i]) {
				dfsutil(i,visited,stack);
			}
		}
		stack.push(s);
		
	}
}


