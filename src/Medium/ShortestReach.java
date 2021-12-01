package Medium;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ShortestReach {
    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s
     */

    static class Node {
        int x;
        List<Node> adjacent;
        int distances;

        public Node(int x) {
            this.x = x;
            this.adjacent = new ArrayList<>();
            this.distances = 0;
        }

        public Node(Node s) {
            this.x = s.x;
            this.adjacent = s.adjacent;
            this.distances = s.distances;
        }
    }
    static Node[] nodelist;
    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {

        nodelist = new Node[n];

        Node x;
        Node y;
        for (int i = 0; i < m; i++) {
            if (nodelist[edges.get(i).get(0)-1] == null) {
                x = new Node(edges.get(i).get(0));
                nodelist[edges.get(i).get(0)-1] = x;
            } else {
                x = nodelist[edges.get(i).get(0)-1];
            }
            if (nodelist[edges.get(i).get(1)-1] == null) {
                y = new Node(edges.get(i).get(1));
                nodelist[edges.get(i).get(1)-1] = y;
            } else {
                y = nodelist[edges.get(i).get(1)-1];
            }
            x.adjacent.add(y);
            y.adjacent.add(x);
        }

        List<Integer> distances = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i+1 == s) continue;
            if (nodelist[i] == null) {
                distances.add(-1);
                continue;
            }
            distances.add(bfs(s, new boolean[n] , nodelist[i]));
        }

        return distances;
    }

    static int bfs(int toFind, boolean[] isVisited, Node currentNode) {

        Queue<Node> queue = new LinkedList<>();
        currentNode.distances = 0;

        queue.add(currentNode);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp.x == toFind) {
                return temp.distances;
            }

            isVisited[temp.x - 1] = true;
            for (Node neighbor : temp.adjacent) {
                if (!isVisited[neighbor.x - 1]) {
                    neighbor.distances = temp.distances + 6;
                    queue.add(new Node(neighbor));
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int q = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, q).forEach(qItr -> {
//            try {
//                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//                int n = Integer.parseInt(firstMultipleInput[0]);
//
//                int m = Integer.parseInt(firstMultipleInput[1]);
//
//                List<List<Integer>> edges = new ArrayList<>();
//
//                IntStream.range(0, m).forEach(i -> {
//                    try {
//                        edges.add(
//                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                                        .map(Integer::parseInt)
//                                        .collect(toList())
//                        );
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                });
//
//                int s = Integer.parseInt(bufferedReader.readLine().trim());
//
//                List<Integer> result = bfs(n, m, edges, s);
//
//                bufferedWriter.write(
//                        result.stream()
//                                .map(Object::toString)
//                                .collect(joining(" "))
//                                + "\n"
//                );
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        bufferedReader.close();
//        bufferedWriter.close();


        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(1,2));
        edges.add(Arrays.asList(1,3));
        edges.add(Arrays.asList(1,4));
        edges.add(Arrays.asList(3,4));
        List<Integer> result = bfs(4, 4, edges, 4);
        System.out.println(result);

    }
}

