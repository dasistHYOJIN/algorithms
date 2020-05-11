package kakao.intern;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_2 {
    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();

        String s1 = "100-200*300-500+20";
        System.out.println(solution.solution(s1));

        String s2 = "100-100-100*100";
        System.out.println(solution.solution(s2));
    }

    public long solution(String expression) {
        long total = 0;

        List<String> operatorsOriginal = Arrays.stream(expression.split("\\d+")).collect(Collectors.toCollection(ArrayList::new));
        List<String> numbersOriginal = Arrays.stream(expression.split("[-*+]")).collect(Collectors.toCollection(ArrayList::new));
        List<Queue<String>> list = initOrders();

        for (Queue<String> orders : list) {
            List<String> operators = new ArrayList<>(operatorsOriginal);
            List<String> numbers = new ArrayList<>(numbersOriginal);

            while (!orders.isEmpty()) {
                String operator = orders.poll();
                for (int i = operators.size() - 1; i > 0; i--) {
                    if (operators.get(i).equals(operator)) {
                        long a = Long.parseLong(numbers.get(i - 1));
                        long b = Long.parseLong(numbers.get(i));
                        long result = a;
                        if (operator.equals("+")) {
                            result += b;
                        } else if (operator.equals("-")) {
                            if (operators.get(i - 1).equals("-")) result += b;
                            else result -= b;
                        } else {
                            result *= b;
                        }

                        numbers.set(i - 1, String.valueOf(result));
                        operators.remove(i);
                        numbers.remove(i);
                    }
                }

                total = Math.max(total, Math.abs(Long.parseLong(numbers.get(0))));
            }
        }

        return total;
    }

    private List<Queue<String>> initOrders() {
        Queue<String> o1 = new LinkedList<>();
        o1.add("+");
        o1.add("-");
        o1.add("*");
        Queue<String> o2 = new LinkedList<>();
        o2.add("+");
        o2.add("*");
        o2.add("-");
        Queue<String> o3 = new LinkedList<>();
        o3.add("-");
        o3.add("+");
        o3.add("*");
        Queue<String> o4 = new LinkedList<>();
        o4.add("-");
        o4.add("*");
        o4.add("+");
        Queue<String> o5 = new LinkedList<>();
        o5.add("*");
        o5.add("+");
        o5.add("-");
        Queue<String> o6 = new LinkedList<>();
        o6.add("*");
        o6.add("-");
        o6.add("+");

        return Arrays.asList(o1, o2, o3, o4, o5, o6);
    }
}
