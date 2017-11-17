package bfs;


import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private static boolean[] visited;
    private static int[] distanceTo;

    private static Vertex[] vertices;
    private static List<Edge> edges = new ArrayList<>();

    private static Queue<Vertex> queue = new LinkedList<>();


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();

        for (int i = 0; i < q; i++) {
            int count_vertex = in.nextInt();
            int count_edge = in.nextInt();

            visited = new boolean[count_vertex + 1];
            vertices = new Vertex[count_vertex + 1];
            distanceTo = new int[count_vertex + 1];
            edges.clear();
            for(int b = 0; b < distanceTo.length; b++){
                distanceTo[b] = -1;
                vertices[b] = new Vertex(b);
            }

            for (int j = 0; j < count_edge; j++) {
                int v1 = in.nextInt();
                int v2 = in.nextInt();
                edges.add(new Edge(getVertex(v1), getVertex(v2)));
            }

            int start = in.nextInt();
            distanceTo[start] = 0;
            queue.add(getVertex(start));
            while (!queue.isEmpty()) {
                bfs();
            }
            for(int y = 1; y < distanceTo.length; y++){
                if(y == start) continue;
                System.out.print(distanceTo[y] + " ");
            }
            System.out.println();
        }
    }

    public static Vertex getVertex(int value) {
        return vertices[value];
    }

    private static void bfs() {
        Vertex v = queue.poll();
        visited[v.getValue()] = true;

        for (Edge edge : adjacents(v)) {
            Vertex end = edge.other(v);
            if(!visited[end.getValue()]){
                distanceTo[end.getValue()] = distanceTo[v.getValue()] + edge.getWeight();
                queue.add(end);
            }
        }
    }

    public static List<Edge> adjacents(Vertex v) {
        return edges.stream()
                .filter((edge -> edge.getV1().equals(v) || edge.getV2().equals(v)))
                .collect(Collectors.toList());
    }
}

class Edge {
    private Vertex v1;
    private Vertex v2;

    private int weight = 6;

    public Edge(Vertex v1, Vertex v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }

    public int getWeight() {
        return weight;
    }

    public Vertex other(Vertex v) {
        if (v1.equals(v)) {
            return v2;
        }
        return v1;
    }


}

class Vertex {
    private int value;

    public Vertex(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        return value == vertex.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}