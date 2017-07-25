package BackTracking;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sumitachauhan on 7/4/17.
 */
public class ShortestPathInMaze {

    static int rowNum[] = {-1, 0, 0, 1};
    static int colNum[] = {0, -1, 1, 0};

    private static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class QNode {
        Point pt;
        int dist;

        public QNode(Point pt, int dist) {
            this.pt = pt;
            this.dist = dist;
        }
    }

    public static boolean isValid(int row, int col, int ROW, int COL) {
        return (row >= 0) && (row < ROW) &&
                (col >= 0) && (col < COL);
    }

    public static void main(String[] args) {
        // These arrays are used to get row and column
    // numbers of 4 neighbours of a given cell
        int ROW = 9;
        int COL = 10;

        int mat[][]  =
        {
            { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
            { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
            { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
            { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
        };

        Point source = new Point(0, 0);
        Point dest = new Point(3, 4);

        int dist = BFS(mat, source, dest, ROW, COL);
        if(dist != -1) {
            System.out.println("Shortest path is " + dist);
        } else {
            System.out.println("Shortest path does not exist");
        }
    }

    static int BFS(int mat[][], Point src, Point dest, int ROW, int COL)
    {   if (mat[src.x][src.y] == 0 || mat[dest.x][dest.y] == 0)
            return -1;
        boolean visited[][] = new boolean[ROW][COL];
        Queue<QNode> q = new LinkedList<>();
        q.add(new QNode(src, 0));
        while (!q.isEmpty()) {
            QNode curr = q.peek();
            Point pt  = curr.pt;
            // If we have reached the destination cell,
            // we are done
            if (pt.x == dest.x && pt.y == dest.y)
                return curr.dist;
            // Otherwise dequeue the front cell in the queue
            // and enqueue its adjacent cells
            q.remove();
            for (int i = 0; i < 4; i++) {
                int row = pt.x + rowNum[i];
                int col = pt.y + colNum[i];

                // if adjacent cell is valid, has path and
                // not visited yet, enqueue it.
                if (isValid(row, col, ROW, COL) && mat[row][col] != 0 &&
                        !visited[row][col])
                {
                    // mark cell as visited and enqueue it
                    visited[row][col] = true;
                    QNode Adjcell = new QNode(new Point(row, col), curr.dist + 1 );
                    q.add(Adjcell);
                }
            }


        }
        return -1;
    }
}