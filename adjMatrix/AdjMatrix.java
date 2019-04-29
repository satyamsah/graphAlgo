package adjMatrix;

public class AdjMatrix {
	
	int vertices;
	boolean [][] adjMat;
	
	public AdjMatrix(int vertices){
		this.vertices=vertices;
		adjMat= new boolean[vertices][vertices];
	}
	
	void addEdge(int i, int j) {
		adjMat[i][j]=true;
		adjMat[j][i]=true;
	}
	
	void removeEdge(int i, int j) {
		adjMat[i][j]=false;
		adjMat[j][i]=false;
	}
	
	void showMatrix() {
		for(int i=0;i<adjMat.length;i++) {
			System.out.print(i+ ": ");
			for(int j=0;j<adjMat[i].length;j++) {
				System.out.print(adjMat[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String str[]) {
		AdjMatrix adjMat= new AdjMatrix(5);
		adjMat.addEdge(0, 1);
		adjMat.addEdge(0, 4);
		adjMat.addEdge(1, 4);
		adjMat.addEdge(1, 3);
		adjMat.addEdge(1, 2);
		adjMat.addEdge(2, 3);
		adjMat.addEdge(3, 4);
		adjMat.showMatrix();
	}
}
