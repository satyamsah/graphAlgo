package mothervertex;

import java.util.LinkedList;

import adjList.AdjList;

public class GraphMotherVertex {
	
	LinkedList<Integer>[] adjList;
	int vertices;
	
	public GraphMotherVertex(int vertices) {
		this.vertices= vertices;
		adjList= new LinkedList[vertices];
		for(int i=0;i<vertices;i++) {
			adjList[i]= new LinkedList<>();
		}
	}
	
	public void addEdge(int i,int j) {
		adjList[i].add(j);
//		adjList[j].add(i);
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
	
	public static void main(String [] args) {
		GraphMotherVertex adjlist = new GraphMotherVertex(7);
		adjlist.addEdge(0, 1);
		adjlist.addEdge(0, 2);
		adjlist.addEdge(1, 3);
		adjlist.addEdge(4,1);
		adjlist.addEdge(5,2);
		adjlist.addEdge(5,6);
		adjlist.addEdge(6, 0);
		adjlist.addEdge(6, 4);
		adjlist.show();
		System.out.println(adjlist.findMotherVertex(0,7));	
	}
	
	public int findMotherVertex(int source,int vertices) {
		for(int i=0;i<adjList.length;i++) {
			int reachablevertices=DFS(i,new boolean[vertices]);
			if(reachablevertices==vertices){
				System.out.print("number of reachablevertices:"+reachablevertices);
				return i;
			}
		}
		return -1;
	}
	
	private int DFS(int source, boolean[] visited) {
		// TODO Auto-generated method stub
		visited[source]=true;
		int sum=0;
		if(adjList[source].size()==0) {
			return 1;
		}
		for(int vertex:adjList[source]) {
			if(!visited[vertex]) {
				sum+=DFS(vertex, visited);
			}
		}
		return sum+1;
	}
}
