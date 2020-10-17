package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] numbers = input.split("\\-|\\+");
        String[] operators = input.split("[^\\-|\\+]+");

        List<Node> nodes = initNodes(numbers, operators);

        // 모든 순서를 정하기
        List<List<Integer>> orders = new ArrayList<>();

        int[] arr = IntStream.range(0, operators.length).toArray();
        permutation(orders, arr, operators.length, operators.length);

        int result = Integer.MAX_VALUE;
        for (List<Integer> order : orders) {
            List<Node> nodes1 = new ArrayList<>(nodes);

            order.forEach(i -> nodes.get(order.get(i)).calculate());
            result = Math.min(result, nodes1.get(0).number);
        }

        System.out.println(result);
    }

    private static List<Node> initNodes(String[] numbers, String[] operators) {
        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i]);
            String operator = (i < numbers.length - 1) ? operators[i + 1] : null;
            Node node = new Node(number, operator);

            nodes.add(node);

            if (i == 0) continue;
            nodes.get(i - 1).nextNode = node;

        }

        return nodes;
    }

    private static void permutation(List<List<Integer>> orders, int[] arr, int N, int R) {
        if (R == 0) {
            orders.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
            return;
        }

        for (int i = N - 1; i >= 0; i--) {
            swap(arr, i, N - 1);
            permutation(orders, arr, N - 1, R - 1);
            swap(arr, i, N - 1);
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public static class Node {
        int number;
        String operator;
        Node nextNode;

        Node(int number, String operator) {
            this.number = number;
            this.operator = operator;
        }

        private void calculate() {
            number += operator.equals("+") ? nextNode.number : nextNode.number * -1;
            nextNode = nextNode.nextNode;
        }
    }
}
