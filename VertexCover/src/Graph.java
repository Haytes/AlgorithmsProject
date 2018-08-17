import java.util.LinkedList;

class Graph
{
    private int numberOfVertices; 
    // Array  of lists for Adjacency List Representation
    public LinkedList<Integer> adj[];
 
    // Constructor
    Graph(int v)
    {
    	numberOfVertices = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    //Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w);  // Add w to v's list.
        adj[w].add(v);  //Graph is undirected
    }

	public int getnumberOfVertices() {
		return numberOfVertices;
	}


}