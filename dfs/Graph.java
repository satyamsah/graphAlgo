package dfs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph {

	LinkedList<Integer>[] adjList;
	int vertices;
	
	public Graph(int vertices) {
		this.vertices= vertices;
		adjList= new LinkedList[vertices];
		for(int i=0;i<vertices;i++) {
			adjList[i]= new LinkedList<>();
		}
	}
	
	public void addEdge(int i,int j) {
		adjList[i].add(j);
		adjList[j].add(i);
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
		Graph adjlist = new Graph(5);
		adjlist.addEdge(0, 1);
		adjlist.addEdge(0, 4);
		adjlist.addEdge(1, 4);
		adjlist.addEdge(1, 3);
		adjlist.addEdge(1, 2);
		adjlist.addEdge(2, 3);
		adjlist.addEdge(3, 4);
		adjlist.show();
		boolean [] visited = new boolean[adjlist.vertices];
		adjlist.dfs(0,visited);
	}

	private void dfs(int s, boolean [] visited ) {
		// TODO Auto-generated method stub
		visited[s]=true;
		System.out.print(s+ " ");
		for(int i : adjList[s]) {
			if(!visited[i]) {
				dfs(i,visited);
			}
		}
	}
}


