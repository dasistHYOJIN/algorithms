import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// 1부터 N까지의 정수 중에 R개의 수를 가진 집합을 출력
public class Combination {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Combination combination = new Combination();

        int N = Integer.parseInt(br.readLine());
        int R = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        combination.doCombination(arr, N, R, 0, 0, new int[R]);
    }

    private void doCombination(int[] arr, int N, int R, int index, int target, int[] combinatedArr) {
        if (target == N) return;
        if (R == 0) {
            String result = Arrays.stream(combinatedArr).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(result);
            return;
        }

        combinatedArr[index] = arr[target];
        doCombination(arr, N, R - 1, index + 1, target + 1, combinatedArr); // 지금 가리키고 있는 인덱스의 값을 넣자
        doCombination(arr, N, R, index, target + 1, combinatedArr); // 지금 가리키고 있는 인덱스의 값을 넣지 말자
    }
}
