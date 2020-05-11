package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        WorkDay[] workDays = initWorkDays(br, N);

        dp(workDays, 0, 0);

        System.out.println(max);
    }

    private static void dp(WorkDay[] workDays, int day, int pay) {
        if (day == workDays.length) {
            max = Math.max(max, pay);
            return;
        }
        if (day > workDays.length) return;

        // 일하거나
        dp(workDays, day + workDays[day].workDay, pay + workDays[day].pay);

        // 다음날 일하거나
        dp(workDays, day + 1, pay);

    }

    private static WorkDay[] initWorkDays(final BufferedReader br, final int n) throws IOException {
        WorkDay[] workDays = new WorkDay[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int workDay = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());

            workDays[i] = new WorkDay(workDay, pay);
        }

        return workDays;
    }

    private static class WorkDay {
        int workDay;
        int pay;

        public WorkDay(final int workDay, final int pay) {
            this.workDay = workDay;
            this.pay = pay;
        }
    }
}
