import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskalsss {

    static class Edge {
        int p1, p2, weight;

        public Edge(int p1, int p2, int weight) {
            this.p1 = p1;
            this.p2 = p2;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int V = 4;
        List<Edge> graphEdges = new ArrayList<Edge>(
                List.of(new Edge(0, 1, 10),
                        new Edge(0, 2, 6),
                        new Edge(0, 3, 5),
                        new Edge(1, 3, 15),
                        new Edge(2, 3, 4)));

        graphEdges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        kruskals(V, graphEdges);
    }

    private static void kruskals(int V, List<Edge> edges) {
        int j = 0;
        int noOfEdges = 0;
        int visit[] = new int[V];
        Edge results[] = new Edge[V];

        while (noOfEdges < V - 1) {
            Edge nextEdge = edges.get(j);
            int x = nextEdge.p1;
            int y = nextEdge.p2;
            if (visit[x] == 0 || visit[y] == 0) {
                results[noOfEdges] = nextEdge;
                noOfEdges++;
                visit[x] = visit[y] = 1;
            }
            j++;
        }
        System.out.println("Following edge of MST:");
        int minCost = 0;
        for (int i = 0; i < noOfEdges; i++) {
            System.out.println(results[i].p1 + "__" + results[i].p2 + "==" + results[i].weight);
            minCost += results[i].weight;
        }
        System.out.println("Total cost of MST: " + minCost);
    }
}