package transitiveClosure;

import java.util.LinkedList;


public class TransitiveAdjList {
	
	LinkedList<Integer>[] adjList;
	int vertices;
	
	public TransitiveAdjList(int vertices) {
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
		TransitiveAdjList adjlist = new TransitiveAdjList(4);
//		adjlist.addEdge(0, 1);
//		adjlist.addEdge(0, 2);
//		adjlist.addEdge(1, 3);
//		adjlist.addEdge(4,1);
//		adjlist.addEdge(5,2);
//		adjlist.addEdge(5,6);
//		adjlist.addEdge(6, 0);
//		adjlist.addEdge(6, 4);
		
		
		
		adjlist.addEdge(0, 1);
		adjlist.addEdge(0, 2);
		adjlist.addEdge(1, 2);
		adjlist.addEdge(2,0);		
		adjlist.addEdge(2,3);		
		
		adjlist.show();
		int[][] mat= adjlist.TrasitiveMat();	
		for(int i=0;i<adjlist.vertices;i++) {
			for(int j=0;j<adjlist.vertices;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}

	private int[][] TrasitiveMat() {
		int[][] mat= new int[vertices][vertices];
		for(int i=0;i<mat.length;i++) {
			DFS(mat,i,i, new boolean[vertices]);
		}
		return mat;
	}

	private void DFS(int[][] mat, int source, int intermediateSource,boolean []visited){
		visited[intermediateSource]=true;
		mat[source][intermediateSource]=1;
		if(adjList[intermediateSource].size()==0) {
			return;
		}
		for(int vertex:adjList[intermediateSource]){
			if(!visited[vertex]) {
				DFS( mat,source, vertex,visited);
			}
		}
	}
}
