package courseschedule;

import java.util.LinkedList;

public class Graph {
	
	    LinkedList<Integer>[] arr;
	    
	    public boolean canFinish(int numCourses, int[][] prerequisites) {
	        arr = new LinkedList[numCourses];
	        for(int i=0;i<numCourses;i++){
	            LinkedList<Integer> ll= new LinkedList<>();
	            arr[i]=ll;
	        }
	        for(int i=0;i<numCourses;i++){
	            arr[prerequisites[i][1]].add(prerequisites[i][0]);
	        }
	        
	        boolean visited[] = new boolean[numCourses];
	        boolean recStack[] = new boolean[numCourses];
	        for(int i=0;i<numCourses;i++){
	            if(iscircular(i,visited,recStack)){
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    boolean iscircular(int i, boolean [] visited, boolean [] recStack){
	        
	        if(recStack[i]){
	            return true;
	        }
	        if(visited[i]){
	            return false;
	        } 
	        else{
	            visited[i]=true;
	            recStack[i]=true;
	            for(int j=0;j<arr[i].size();j++) {
					if(iscircular(arr[i].get(j),visited,recStack)){
	                    return true;
	                }
				}
	            recStack[i]=false;
	            return false;
	        }
	        
	    }  
	    
	    
	    public static void main(String [] str) {
	    	Graph g = new Graph();
	    	int [][] courseList= new int[2][2];
	    	courseList[0][0]=1;
	    	courseList[0][1]=0;
//	    	courseList[1][0]=0;
//	    	courseList[1][1]=1;
	    	System.out.println(g.canFinish(2,courseList ));
	    }
}
