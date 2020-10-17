package programmers;

public class SkillCheck1 {
    public static void main(String[] args) {
        SkillCheck1 skillCheck1 = new SkillCheck1();

        System.out.println(String.join(" ", skillCheck1.solution("sun bed car".split(" "), 1)));
        System.out.println(String.join(" ", skillCheck1.solution("abce abcd cdx".split(" "), 2)));
        System.out.println(String.join(" ", skillCheck1.solution("as as as".split(" "), 1)));
    }

    public String[] solution(String[] strings, int n) {
        // 삽입 정렬로 가보자

        for (int targetIndex = 1; targetIndex < strings.length; targetIndex++) {
            innerSort(strings, targetIndex, n);
        }

        return strings;
    }

    private void innerSort(String[] strings, int targetIndex, int n) {
        char key = strings[targetIndex].charAt(n);
        for (int index = targetIndex - 1; index >= 0 && strings[index].charAt(n) >= key; index--) {
            if (strings[index].charAt(n) == key && strings[targetIndex].length() > n+1 && strings[index].length() > n+1) {
                innerSort(strings, targetIndex, n + 1);
            } else {
                swap(strings, targetIndex, index);
            }

            targetIndex = index;
        }
    }

    private void swap(final String[] strings, final int i1, final int i2) {
        String temp = strings[i1];
        strings[i1] = strings[i2];
        strings[i2] = temp;
    }

}
