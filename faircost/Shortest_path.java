package faircost;

//A Java naive recursive solution to find min cost path from station 0 
//to station N-1 
class Shortest_path 
{ 

	static int INF = Integer.MAX_VALUE,N = 4; 
 static int min=Integer.MAX_VALUE;
	// A recursive function to find the shortest path from 
	// source 's' to destination 'd'. 
	static void minCostRec(int cost[][], int i, int d,int sum) 
	{ 
		// If source is same as destination 
		// or destination is next to source 
		if (i == d) 
			min=Math.min(min, sum);
	
		// Initialize min cost as direct ticket from 
		// source 's' to destination 'd'. 
	
		// Try every intermediate vertex to find minimum 
		for (int j = i+1; j<=d; j++){ 
				minCostRec(cost, j, d,sum+cost[i][j]); 
		} 
	} 
	
	// This function returns the smallest possible cost to 
	// reach station N-1 from station 0. This function mainly 
	// uses minCostRec(). 
	static int minCost(int cost[][]) 
	{ 
		 minCostRec(cost,0, N-1,0);
   	 return min;
   
	} 

	public static void main(String args[]) 
	{ 
		int cost[][] = { {0, 15, 80, 90}, 
					   {INF, 0, 40, 50}, 
					   {INF, INF, 0, 70}, 
					   {INF, INF, INF, 0} 
					}; 
		System.out.println("The Minimum cost to reach station "+ N+ 
											" is "+minCost(cost)); 
	} 

}/* This code is contributed by Rajat Mishra */
