import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;


/*Implement the Vertex Cover problem; that is, given graph G and integer k, 
 * answer the question of whether or not there is a vertex cover of size k or less.  

Begin by using a brute-force algorithm to check all possible sets of vertices of size k
to find an acceptable vertex cover, and measure the running time on a number of input graphs.  

Then try to reduce the running time using any heuristics you can think of.  

Next, try to find approximate solutions to the problem in the sense of finding the 
smallest set of vertices that forms a vertex cover and analyzing its running time.  

*/



public class VertexCover {

	
	static void findCombinations(int[] items, Graph g) {
	    for (int k = 1; k <= items.length; k++) {
	    	kCombinations(items, 0, k, new int[k], g);
	    }
	}
	public static void kCombinations(int[] items, int n, int k, int[] arr,Graph g) {
	    if (k == 0) {
	        System.out.println(Arrays.toString(arr) + " " +isVertexCover(g, arr));
	    } else {
	        for (int i = n; i <= items.length - k; i++) {
	            arr[arr.length - k] = items[i];
	            kCombinations(items, i + 1, k - 1, arr, g);
	        }
	    }
	}
	
	
	//Assumes all integer values in array are vertices in the Graph g
	public static boolean isVertexCover (Graph g, int[] array) {
		boolean[] visited = new boolean[g.getnumberOfVertices()];
		Arrays.fill(visited, false);
		Iterator<Integer> iterator;
		for(int x = 0; x < array.length; x++) {
			int v = array[x];
			iterator = g.adj[v].iterator();
			//marks all vertices attached to v as visited
			while(iterator.hasNext()) {
				int u = iterator.next();
				visited[u] = true;
			}
			//marks vertex v as visited
			visited[v] = true;
		}
		
		//Checks if all vertices have been visited
		for(int i = 0; i < visited.length; i++) {
			if(!visited[i]) {
				return false;
			}
		}
		return true;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(7);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        int[] array = {0,1,2,3,4,5,6};
        findCombinations(array,g);
        //System.out.println(isVertexCover(g,array));
	}

}
