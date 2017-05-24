package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sumitachauhan on 3/8/17.
 */
public class BFS {

    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }

//    BFS(int vertices, LinkedList[] adjList)
//    {
//        V=vertices;
//        adj = adjList;
//    }

    // prints BFS traversal from a given source s
    void BFS(int s)
    {

        boolean visited[] = new boolean[V];

        Queue<Integer> queue = new LinkedList<>();

        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            s = queue.poll();
            System.out.print(s+" ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 4;
        LinkedList[] l = new LinkedList[4];
        LinkedList<Integer> a1 = new LinkedList<>();
        a1.add(1);
        LinkedList<Integer> a2 = new LinkedList<>();
        a2.add(2);
        LinkedList<Integer> a3 = new LinkedList<>();
        a2.add(3);
        LinkedList<Integer> a4 = new LinkedList<>();
        a4.add(4);

        l[0] = a1;
        l[1] = a2;
        l[2] = a3;
        l[3] = a4;

        BFS obj = new BFS();
        obj.V=4;
        obj.adj=l;
        obj.addEdge(1,2);
        obj.addEdge(2,3);
        obj.addEdge(3,4);
        obj.addEdge(4,1);
        obj.BFS(1);

    }

}
