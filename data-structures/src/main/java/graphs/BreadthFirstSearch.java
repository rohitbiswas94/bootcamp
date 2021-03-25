package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    private LinkedList<Integer>[] adj;
    private int noOfVertices;
    private Queue<Integer> queue;

    BreadthFirstSearch(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adj = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            adj[i] = new LinkedList<>();
        }
        queue = new LinkedList<>();
    }

    private void addEdge(int v, int e) {
        adj[v].add(e);
    }

    private void bfs(int v, boolean[] visited) {
        visited[v] = true;
        queue.add(v);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + "\t");
            for (int node : adj[vertex]) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }
    }

    private void breadthFirstSearch() {
        boolean[] visited = new boolean[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            if (!visited[i]) bfs(i, visited);
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(4);
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 2);
        breadthFirstSearch.addEdge(2, 0);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 3);
        breadthFirstSearch.breadthFirstSearch();
    }

}
