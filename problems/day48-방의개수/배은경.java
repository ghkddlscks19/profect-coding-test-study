import java.util.*;

class Solution {
    public class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node n = (Node) o;
            return x == n.x && y == n.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public class Edge {
        Node node1, node2;

        public Edge(Node node1, Node node2) {
            this.node1 = node1;
            this.node2 = node2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Edge)) return false;
            Edge e = (Edge) o;
            return (node1.equals(e.node1) && node2.equals(e.node2)) ||
                   (node1.equals(e.node2) && node2.equals(e.node1));
        }

        @Override
        public int hashCode() {
            return node1.hashCode() + node2.hashCode();
        }
    }

    public int solution(int[] arrows) {
        int answer = 0;
        Set<Node> nodeSet = new HashSet<>();
        Set<Edge> edgeSet = new HashSet<>();
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        int x = 0, y = 0;
        nodeSet.add(new Node(x, y));

        for (int i = 0; i < arrows.length; i++) {
            for (int step = 0; step < 2; step++) {
                Node n1 = new Node(x, y);
                x += dx[arrows[i]];
                y += dy[arrows[i]];
                Node n2 = new Node(x, y);
                Edge edge = new Edge(n1, n2);
                
                if (nodeSet.contains(n2) && !edgeSet.contains(edge)
                    answer++;
                
                nodeSet.add(n2);
                edgeSet.add(edge);
            }
        }
        return answer;
    }
}
