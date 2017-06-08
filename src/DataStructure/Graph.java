package DataStructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Created by sumitachauhan on 5/24/17.
 */
public class Graph {

    Vertex[] graphVertices;
    public static void main(String[] args) throws IOException {
            //read the file from console
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter graph input file name: ");
            String file = sc.nextLine();
            Graph graph = new Graph(file);
            //graph.print();
            //graph.bfs();
            graph.dfs();
        }
    //contructor to create the graph from the given file -
    // file should have no of vertices in the graph, vertex name and edges
    public Graph(String file) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file));

        String graphType = sc.next();
        boolean undirected=true;
        if (graphType.equals("directed")) {
            undirected=false;
        }
        //size of graphVertices = no of vertices in the graph.
        graphVertices = new Vertex[sc.nextInt()];

        //read the vertices, put then in the vertex array
        for(int i=0; i<graphVertices.length; i++){
            graphVertices[i] = new Vertex(sc.next(), null);
        }

        //read the edges, set neighbor for each vertex
        while(sc.hasNext()){
            int vertex1 = indexForName(sc.next());
            int vertex2 = indexForName(sc.next());
            //create and edge between two vertices
            graphVertices[vertex1].neighnor = new Neighbor(vertex2, graphVertices[vertex1].neighnor);
            //in case of undirected graph there should be two edges between nodes
            if(undirected){
                graphVertices[vertex2].neighnor = new Neighbor(vertex1, graphVertices[vertex2].neighnor);
            }
        }


    }

    private int indexForName(String name){
        for(int i=0; i<graphVertices.length; i++){
            if(graphVertices[i].name.equals(name))
                return i;
        }
        return -1;
    }

    private void dfs(int vertex, boolean[] visited){
        visited[vertex]=true;
        System.out.println(graphVertices[vertex].name);
        for(Neighbor nbr = graphVertices[vertex].neighnor; nbr!=null; nbr=nbr.next){
            //visit only not visited neighbors - will help in backtracking
            if(!visited[nbr.vertexNo]){
            dfs(nbr.vertexNo, visited);
            }
        }
    }

    public void dfs(){
        boolean[] visited = new boolean[graphVertices.length];
        for(int v=0; v<visited.length; v++){
            if(!visited[v]){
                System.out.println("starting at: " + graphVertices[v].name);
                dfs(v, visited);
            }
        }

    }

    private void bfs(int vertex, boolean[] visited, MyQueue<Integer> queue){
        visited[vertex]=true;
        queue.enqueue(vertex);

        while(!queue.isEmpty()){
            int v = queue.dequeue();
            for(Neighbor nbr = graphVertices[v].neighnor; nbr!=null; nbr=nbr.next){
                if(!visited[nbr.vertexNo]){
                    System.out.println("\n" + graphVertices[v].name + "--" + graphVertices[nbr.vertexNo].name);
                    visited[nbr.vertexNo]=true;
                    queue.enqueue(nbr.vertexNo);
                }
            }

        }
    }

    public void bfs(){
        boolean[] visited = new boolean[graphVertices.length];
        MyQueue<Integer> queue = new MyQueue<Integer>();
        for(int v=0; v<graphVertices.length; v++){
            if(!visited[v]){
                System.out.println("starting at: " + graphVertices[v].name);
                queue.clear();
                bfs(v,visited,queue);
            }
        }
    }

    private int drsTopSort(int vertex, boolean[] visited, int[] topnum, int n){
        visited[vertex]=true;
        for (Neighbor nbr=graphVertices[vertex].neighnor; nbr!=null; nbr=nbr.next){
            if(!visited[nbr.vertexNo]){
                n = drsTopSort(nbr.vertexNo, visited, topnum,n);
            }
        }
        //asign number to vertices
        topnum[vertex]=n;
        return n-1;
    }

    public void drsTopSort(){
        boolean[] visited = new boolean[graphVertices.length];
        int[] topnum = new int[graphVertices.length];
        int n = graphVertices.length-1;
        for(int v=0; v<graphVertices.length; v++){
            if(!visited[v]){
                n = drsTopSort(v, visited,topnum,n);
            }
        }
        //print topnum to get the topological ordering.

    }
}

class Vertex{
    String name;
    Neighbor neighnor;
    public Vertex(String name, Neighbor nbr){
        this.name=name;
        this.neighnor=nbr;
    }
}

class Neighbor{
    int vertexNo;
    Neighbor next;
    public Neighbor(int vno, Neighbor nbr){
        vertexNo = vno;
        next = nbr;
    }
}


