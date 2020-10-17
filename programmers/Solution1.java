package programmers;

public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        System.out.println(solution.solution("82195", "64723"));
        System.out.println(solution.solution("00000000000000000000", "91919191919191919191"));
    }

    public int solution(String p, String s) {
        int answer = 0;

        for (int i = 0; i < p.length(); i++) {
            int P = p.charAt(i) - '0';
            int S = s.charAt(i) - '0';
            answer += Math.min(turnRight(P, S), turnLeft(P, S));
        }

        return answer;
    }

    private int turnRight(int p, int s) {
        int count = 0;
        while (p % 10 != s) {
            count++;
            p++;
        }
        return count;
    }

    private int turnLeft(int p, int s) {
        int count = 0;
        p += 10;
        while (p % 10 != s) {
            count++;
            p--;
        }
        return count;
    }
}
