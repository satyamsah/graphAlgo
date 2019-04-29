package adjListUsingHashMap;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Graph {
	int vertexLimit;
	HashMap<Integer,LinkedList<Integer>> edgeLists;
	
	public Graph(int vertexLimit) {
		this.vertexLimit=vertexLimit;
		edgeLists= new HashMap<>();
		
	}
	void addEdge(int source,int destination){
		if(!edgeLists.containsKey(source)) {
			LinkedList<Integer> ll=new LinkedList<Integer>();
			ll.add(destination);
			edgeLists.put(source, ll);
		}else {
			LinkedList<Integer> ll=edgeLists.get(source);
			ll.add(destination);
			edgeLists.put(source, ll);
		}
	}
	
	void DFS(int source) {
		boolean visited[]= new boolean[vertexLimit];
		DFSUtil(source,visited);	
	}
	
	private void DFSUtil(int source, boolean[] visited) {
		visited[source]=true;
		System.out.print(source+"->");
		if (edgeLists.containsKey(source)){
			LinkedList<Integer>  edges=edgeLists.get(source);
			for(int edge:edges) {
				if( !visited[edge]==true) {
					DFSUtil(edge,visited);
				}
			}
		}
	}

	void BFS(int source) {
		boolean visited[]= new boolean[vertexLimit];
		Queue<Integer> queue= new LinkedList<>();
		queue.add(source);
		visited[source]=true;
		System.out.print(source+"->");
		while(queue.size()>0) {
			int  top=queue.remove();
			if(edgeLists.containsKey(top)) {
				for(int vertex: edgeLists.get(top)) {
					if(!visited[vertex]) {
						System.out.print(vertex+"->");
						queue.add(vertex);
						visited[vertex]=true;
					}
				}
			}
		}
	}
	
	public void show() {
		for(Map.Entry<Integer, LinkedList<Integer>> entry : edgeLists.entrySet()) {
			System.out.println("vertex["+entry.getKey()+"]:edge"+entry.getValue());
		}
	}
	
	public static void main(String arr[]) {
		Graph g= new Graph(8);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(3,6);
		g.addEdge(6,7);
		g.addEdge(5,4);
		g.addEdge(3,5);
		g.addEdge(3,1);
		g.show();
		g.BFS(1);
		System.out.println();
		g.DFS(1);
		
	}

}


/*import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

public class Graph {
	
	int vertexLimit;
	LinkedList<Integer>[] edgeLists;
	
	public Graph(int vertexLimit) {
		this.vertexLimit=vertexLimit;
		edgeLists= new LinkedList[vertexLimit];
		for(int i=0;i<vertexLimit;i++) {
			edgeLists[i]= new LinkedList<Integer>();
		}
	}
	
	void addEdge(int source,int destination){
		edgeLists[source].add(destination);
	}
	
	void DFS(int source) {
		boolean visited[]= new boolean[vertexLimit];
		DFSUtil(source,visited);	
	}
	
	private void DFSUtil(int source, boolean[] visited) {
		visited[source]=true;
		System.out.print(source+"->");
		LinkedList<Integer> edges=edgeLists[source];
		for(int edge:edges) {
			if( !visited[edge]==true) {
				DFSUtil(edge,visited);
			}
		}
	}

	void BFS(int source) {
		boolean visited[]= new boolean[vertexLimit];
		Queue<Integer> queue= new LinkedList<>();
		queue.add(source);
		visited[source]=true;
		System.out.println();
		System.out.print(source+"->");
		while(queue.size()>0) {
			for(int vertex: edgeLists[queue.peek()]) {
				if(!visited[vertex]) {
					System.out.print(vertex+"->");
					queue.add(vertex);
					visited[vertex]=true;
				}
			}
			queue.poll();
		}
		
	}
	
	

	public void show() {
		for(int i=0;i<vertexLimit;i++) {
			System.out.println("vertex["+i+"]:edge"+edgeLists[i]);
		}
	}
	
	public static void main(String arr[]) {
		Graph g= new Graph(8);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(3,6);
		g.addEdge(6,7);
		g.addEdge(5,4);
		g.addEdge(3,5);
		g.addEdge(3,1);
		g.show();
		g.BFS(1);
		System.out.println();
		g.DFS(1);
		
	}

}
*/
