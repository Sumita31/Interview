package Graph;

import java.util.Iterator;
import java.util.LinkedList;


public class DFS {
    private int V;
    private LinkedList<Integer> adj[];

    // A function used by DFS
    void DFSUtil(int v, boolean visited[])
    {
        visited[v] = true;
        System.out.print(v+" ");

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v)
    {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }

}
