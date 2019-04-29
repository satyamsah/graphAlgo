package adjList;

import java.util.LinkedList;

public class AdjList {

	LinkedList<Integer>[] adjList;
	int vertices;
	
	public AdjList(int vertices) {
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
	public static void main(String [] str) {
		AdjList adjlist = new AdjList(5);
		adjlist.addEdge(0, 1);
		adjlist.addEdge(0, 4);
		adjlist.addEdge(1, 4);
		adjlist.addEdge(1, 3);
		adjlist.addEdge(1, 2);
		adjlist.addEdge(2, 3);
		adjlist.addEdge(3, 4);
		adjlist.show();
	}

}
