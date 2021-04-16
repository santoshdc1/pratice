package week5;
import java.util.*;
import java.util.LinkedList;

public class week5 {
    private int V;

    private LinkedList<Integer> adj[];
    private int time = 0;
    private int NIL = -1;

    @SuppressWarnings("unchecked")
        // Constructor
    week5(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList<Integer>();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w);
        adj[w].add(v);
    }


    void getVulnerableNodesUtil(int u, boolean visited[], int disc[],
                                int low[], int parent[], boolean getVulnerableNodes[])
    {


        int children = 0;

        visited[u] = true;

        disc[u] = low[u] = ++time;


        Iterator<Integer> i = adj[u].iterator();
        while (i.hasNext())
        {
            int v = i.next();

            if (!visited[v])
            {
                children++;
                parent[v] = u;
                getVulnerableNodesUtil(v, visited, disc, low, parent, getVulnerableNodes);

                low[u]  = Math.min(low[u], low[v]);

                if (parent[u] == NIL && children > 1)
                    getVulnerableNodes[u] = true;

                if (parent[u] != NIL && low[v] >= disc[u])
                    getVulnerableNodes[u] = true;
            }

            // Update low value of u for parent function calls.
            else if (v != parent[u])
                low[u]  = Math.min(low[u], disc[v]);
        }
    }

    // The function to do DFS traversal. It uses recursive function getVulnerableNodesUtil()
    ArrayList<Integer> getVulnerableNodes()
    {
        // Mark all the vertices as not visited
        ArrayList<Integer> vulnerableNodes = new ArrayList<Integer>(); // final Array list of vulnerable nodes
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];
        boolean getVulnerableNodes[] = new boolean[V]; // To store Vulnerable Nodes

        // Initialize parent and visited, and getVulnerableNodes
        // arrays
        for (int i = 0; i < V; i++)
        {
            parent[i] = NIL;
            visited[i] = false;
            getVulnerableNodes[i] = false;
        }

        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                getVulnerableNodesUtil(i, visited, disc, low, parent, getVulnerableNodes);

        for (int i = 0; i < V; i++)
            if (getVulnerableNodes[i] == true)
                vulnerableNodes.add(i);


        return vulnerableNodes;
    }


    // Method to convert Vulnerable Node Keys to its Value
    ArrayList<Integer> VulnerableNodes(HashMap<Integer, Integer> networks){
        ArrayList<Integer> VulnerableNodesKey = getVulnerableNodes();
        ArrayList<Integer> VulnerableNodesValue = new ArrayList<Integer>();

        for (int i=0; i< VulnerableNodesKey.size(); i++) {
            VulnerableNodesValue.add(networks.get(VulnerableNodesKey.get(i)));
        }

        return VulnerableNodesValue;
    }

    public static void main(String args[])
    {

        HashMap<Integer, Integer> networks = new HashMap<Integer, Integer>();
        networks.put(0, 5);
        networks.put(1, 9);
        networks.put(2, 7);
        networks.put(3, 12);
        networks.put(4, 13);


        // Create graph
        week5 graph = new week5(5);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(4, 3);


        System.out.println("Vulnerable Nodes in the graph:");
        System.out.println(graph.VulnerableNodes(networks));

    }
}