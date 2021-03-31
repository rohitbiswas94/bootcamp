package graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class DepthFirstSearch {

    private LinkedList<Integer>[] adj;
    private int noOfVertices;

    DepthFirstSearch(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adj = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }
 
    private void addEdge(int v, int e) {
        adj[v].add(e);
    }

    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + "\t");
        for (int vertex : adj[v]) {
            if (!visited[vertex]) {
                dfs(vertex, visited);
            }
        }
    }

    private void depthFirstSearch() {
        boolean[] visited = new boolean[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            if (!visited[i]) dfs(i, visited);
        }
    }

    public static void main(String[] args) {
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(4);
        depthFirstSearch.addEdge(0, 1);
        depthFirstSearch.addEdge(0, 2);
        depthFirstSearch.addEdge(1, 2);
        depthFirstSearch.addEdge(2, 0);
        depthFirstSearch.addEdge(2, 3);
        depthFirstSearch.addEdge(3, 3);
        depthFirstSearch.depthFirstSearch();
    }

}
