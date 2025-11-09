import java.util.*;

class Solution {
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    
    static class Node {
        int x;
        int y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (! (o instanceof Node))
                return false;
            
            Node n = (Node) o;
            return x == n.x && y == n.y;
        }
    
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    static class Edge {
        Node from, to;
        Edge(Node from, Node to) {
            this.from = from;
            this.to = to;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Edge)) return false;
            Edge e = (Edge) o;

            return (from.equals(e.from) && to.equals(e.to)) ||
                   (from.equals(e.to) && to.equals(e.from));
        }
        
        @Override
        public int hashCode() {
            return from.hashCode() + to.hashCode();
        }
    }

    
    public int solution(int[] arrows) {
        int answer = 0;
        
        Set<Node> visitedNodes = new HashSet<>();
        Set<Edge> visitedEdges = new HashSet<>();
        
        Node current = new Node(0, 0);
        visitedNodes.add(current);
        
        for (int arrow : arrows) {
            for (int i = 0; i < 2; i++) {
                Node next = new Node(current.x + dx[arrow], current.y + dy[arrow]);
                Edge edge = new Edge(current, next);
                
                if (visitedNodes.contains(next) && !visitedEdges.contains(edge)) {
                    answer++;
                }
                
                visitedNodes.add(next);
                visitedEdges.add(edge);
                
                current = next;
            }
        }
        return answer;
    }
}
