package test.kakao.intern;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_2_2 {
    public static void main(String[] args) {
        Solution_2_2 solution = new Solution_2_2();

        String s1 = "100-200*300-500+20";
        System.out.println(solution.solution(s1));

        String s2 = "100-100-100*100";
        System.out.println(solution.solution(s2));

        String s3 = "30*100-400*100+250";
        System.out.println(solution.solution(s3));
    }

    public long solution(String expression) {
        long total = 0;

        List<String> operatorsOriginal = Arrays.stream(expression.split("\\d+")).filter(s -> s.length() > 0).collect(Collectors.toList());
        List<Long> numbersOriginal = Arrays.stream(expression.split("[-*+]")).map(Long::parseLong).collect(Collectors.toList());
        List<Stack<String>> list = initOrders(operatorsOriginal);

        for (Stack<String> orders : list) {
            Deque<String> operators = new LinkedList<>(operatorsOriginal);
            Deque<Long> numbers = new LinkedList<>(numbersOriginal);

            total = Math.max(total, operate(orders, numbers, operators));
        }

        return total;
    }

    private long operate(Stack<String> orders, Deque<Long> numbers, Deque<String> operators) {
        while (!orders.isEmpty()) {
            String focusedOperator = orders.pop();

            Deque<String> nextOperators = new LinkedList<>();
            Deque<Long> nextNumbers = new LinkedList<>();

            long number = numbers.pollFirst();
            while (!operators.isEmpty()) {
                String operator = operators.pollFirst();

                if (focusedOperator.equals(operator)) {
                    number = calculate(operator, number, numbers.pollFirst());
                } else {
                    nextNumbers.addLast(number);
                    nextOperators.addLast(operator);

                    number = numbers.pollFirst();
                }
            }

            nextNumbers.add(number);
            operators = nextOperators;
            numbers = nextNumbers;
        }

        return Math.abs(numbers.poll());
    }

    private long calculate(String operator, long num1, long num2) {
        if (operator.equals("+")) {
            num1 += num2;
        } else if (operator.equals("-")) {
            num1 -= num2;
        } else {
            num1 *= num2;
        }
        return num1;
    }

    private List<Stack<String>> initOrders(List<String> operators) {
        Object[] objects = operators.stream().distinct().toArray();
        List<Stack<String>> orders = new ArrayList<>();

        permutation(orders, objects, objects.length, objects.length);

        return orders;
    }

    private void permutation(List<Stack<String>> orders, Object[] objects, int n, int r) {
        if (r == 0) {
            Stack<String> stack = new Stack<>();
            stack.addAll(Arrays.stream(objects).map(Object::toString).collect(Collectors.toList()));
            orders.add(stack);
            return;
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(objects, i, n - 1);
            permutation(orders, objects, n - 1, r - 1);
            swap(objects, i, n - 1);
        }
    }

    private void swap(Object[] objects, int i1, int i2) {
        Object temp = objects[i1];
        objects[i1] = objects[i2];
        objects[i2] = temp;
    }
}
