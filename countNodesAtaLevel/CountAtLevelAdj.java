package countNodesAtaLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.management.Query;


public class CountAtLevelAdj {LinkedList<Integer>[] adjList;
	int vertices;
	
	public CountAtLevelAdj(int vertices) {
		this.vertices= vertices;
		adjList= new LinkedList[vertices];
		for(int i=0;i<vertices;i++) {
			adjList[i]= new LinkedList<>();
		}
	}
	
	public void addEdge(int i,int j) {
		adjList[i].add(j);
	//	adjList[j].add(i);
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
		CountAtLevelAdj adjlist = new CountAtLevelAdj(7);
		adjlist.show();
		
		adjlist.addEdge(0 ,1);
		adjlist.addEdge(0 ,2);
		adjlist.addEdge( 1 ,3);
		adjlist.addEdge(1 ,4); 
		adjlist.addEdge(1, 5);
		adjlist.addEdge(2, 6);
		
		Map<Integer, Integer> levelMap=adjlist.cntLevel(0);	
		System.out.println(levelMap.get(2));
	}

	private Map<Integer, Integer> cntLevel(int source) {
		Queue<Integer> queue= new LinkedList<>();
		queue.add(source);
		List<Integer> children;
		Map<Integer, Integer> levelMap= new HashMap<>();
		int level=0;
		while(true) {
			levelMap.put(level,queue.size());
			level++;
			children=new ArrayList<>();
			while(queue.size()>0) {
				int top=queue.remove();
				children.addAll(adjList[top]);
			}
			queue.addAll(children);
			if(queue.size()==0) {
				break;
			}
		}
		return levelMap;
	}

}
