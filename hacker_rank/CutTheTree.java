package hacker_rank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CutTheTree {

    public static void main(String[] args) {
        List<Integer> data1 = Arrays.stream(new int[]{100, 200, 100, 500, 100, 600}).boxed().collect(Collectors.toList());
        List<List<Integer>> edges1 = Stream.of(
                Arrays.stream(new int[]{1, 2}).boxed().collect(Collectors.toList()),
                Arrays.stream(new int[]{2, 3}).boxed().collect(Collectors.toList()),
                Arrays.stream(new int[]{2, 5}).boxed().collect(Collectors.toList()),
                Arrays.stream(new int[]{4, 5}).boxed().collect(Collectors.toList()),
                Arrays.stream(new int[]{5, 6}).boxed().collect(Collectors.toList())).collect(Collectors.toList());
//        System.out.println(cutTheTree(data1, edges1));

        List<Integer> data2 = Arrays.stream(new int[]{205, 573, 985, 242, 830, 514, 592, 263, 142, 915}).boxed().collect(Collectors.toList());
        List<List<Integer>> edges2 = Stream.of(
                Arrays.stream(new int[]{2, 8}).boxed().collect(Collectors.toList()),
                Arrays.stream(new int[]{10, 5}).boxed().collect(Collectors.toList()),
                Arrays.stream(new int[]{1, 7}).boxed().collect(Collectors.toList()),
                Arrays.stream(new int[]{6, 9}).boxed().collect(Collectors.toList()),
                Arrays.stream(new int[]{4, 3}).boxed().collect(Collectors.toList()),
                Arrays.stream(new int[]{8, 10}).boxed().collect(Collectors.toList()),
                Arrays.stream(new int[]{5, 1}).boxed().collect(Collectors.toList()),
                Arrays.stream(new int[]{7, 6}).boxed().collect(Collectors.toList()),
                Arrays.stream(new int[]{9, 4}).boxed().collect(Collectors.toList())).collect(Collectors.toList());
        System.out.println(cutTheTree(data2, edges2));
    }

    public static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {
        Map<Integer, Node> tree = initTree(data, edges);

        int total = tree.get(1).getTotalBudget();

        System.out.println(total);

        return tree.values().stream()
                .map(Node::getTotalBudget)
                .map(totalBudget -> Math.abs(total - totalBudget * 2))
                .min(Math::min).orElse(total);
    }

    private static Map<Integer, Node> initTree(List<Integer> data, List<List<Integer>> edges) {
        Map<Integer, Node> tree = new HashMap<>();

        tree.put(1, new Node(data.get(0)));

        bareChildNode(data, edges, tree, 1);

        return tree;
    }

    private static void bareChildNode(List<Integer> data, List<List<Integer>> edges, Map<Integer, Node> tree, int index) {
        int i = 0;
        while (i < edges.size()) {
            if (!edges.get(i).contains(index)) {
                i++;
                continue;
            }

            List<Integer> edge = edges.remove(i);

            int childIndex = (edge.get(0) == index) ? edge.get(1) : edge.get(0);
            Node childNode = new Node(data.get(childIndex - 1));

            tree.get(index).childNodes.add(childNode);
            tree.put(childIndex, childNode);

            bareChildNode(data, edges, tree, childIndex);
        }
    }

    private static class Node {
        int budget;
        List<Node> childNodes;

        int total;

        public Node(final int budget) {
            this.budget = budget;
            this.childNodes = new ArrayList<>();

            this.total = 0;
        }

        int getTotalBudget() {
            if (this.total == 0) {
                total = budget + childNodes.stream()
                        .map(Node::getTotalBudget)
                        .reduce(Integer::sum)
                        .orElse(0);
                System.out.println(budget + " : " + total);
            }

            return total;
        }
    }
}
