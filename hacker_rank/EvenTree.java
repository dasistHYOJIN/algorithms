package hacker_rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvenTree {
    static Node[] tree;

    public static void main(String[] args) {
        List<Integer> t_from = new ArrayList<>();
        t_from.add(2);
        t_from.add(3);
        t_from.add(4);
        t_from.add(5);
        t_from.add(6);
        t_from.add(7);
        t_from.add(8);
        t_from.add(9);
        t_from.add(10);

        List<Integer> t_to = new ArrayList<>();
        t_to.add(1);
        t_to.add(1);
        t_to.add(3);
        t_to.add(2);
        t_to.add(1);
        t_to.add(2);
        t_to.add(6);
        t_to.add(8);
        t_to.add(8);

        System.out.println(evenForest(10, 9, t_from, t_to));
    }

    static int evenForest(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {
        Node[] tree = initTree(t_nodes, t_from, t_to);



        System.out.println(tree[0].countNode());
        return 0;
    }

    static Node[] initTree(int t_nodes, List<Integer> t_from, List<Integer> t_to) {
        tree = new Node[t_nodes];

        for (int i = 1; i <= t_nodes; i++) {
            tree[i - 1] = new Node();

            while (t_from.contains(i)) {
                int index = t_from.indexOf(i);
                tree[i - 1].childNodeIndex.add(t_to.get(index));

                t_from.remove(index);
                t_to.remove(index);
            }

            while (t_to.contains(i)) {
                int index = t_to.indexOf(i);
                tree[i - 1].childNodeIndex.add(t_from.get(index) - 1);

                t_from.remove(index);
                t_to.remove(index);
            }
        }

        return tree;
    }

    static class Node {
        List<Integer> childNodeIndex = new ArrayList<>();
        int countOfChild = -1;

        int countNode() {
            if (countOfChild == -1) {
                countOfChild = childNodeIndex.stream()
                        .map(i -> tree[i].countNode())
                        .reduce(Integer::sum)
                        .orElse(0);
            }

            return countOfChild + 1;
        }
    }
}
