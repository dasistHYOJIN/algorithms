package hacker_rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheGridSearch {
    public static void main(String[] args) {
        String[] G1 = {
                "7283455864",
                "6731158619",
                "8988242643",
                "3830589324",
                "2229505813",
                "5633845374",
                "6473530293",
                "7053106601",
                "0834282956",
                "4607924137"};
        String[] P1 = {"9505", "3845", "3530"};

        String[] G2 = {
                "400453592126560",
                "114213133098692",
                "474386082879648",
                "522356951189169",
                "887109450487496",
                "252802633388782",
                "502771484966748",
                "075975207693780",
                "511799789562806",
                "404007454272504",
                "549043809916080",
                "962410809534811",
                "445893523733475",
                "768705303214174",
                "650629270887160"};
        String[] P2 = {"99", "99"};

        String[] G3 = {
                "111111111111111",
                "111111111111111",
                "111111011111111",
                "111111111111111",
                "111111111111111"};
        String[] P3 = {"11111", "11111", "11110"};

        String[] G4 = {
                "456712",
                "561245",
                "123667",
                "781288"};
        String[] P4 = {"45", "67"};

//        System.out.println(gridSearch(G1, P1));
//        System.out.println(gridSearch(G2, P2));
//        System.out.println(gridSearch(G3, P3));
        System.out.println(gridSearch(G4, P4));
    }

    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {
        List<Integer> baseSeroes = new ArrayList<>();
        List<Integer> baseGaroes = new ArrayList<>();

        for (int i = 0; i <= G.length - P.length; i++) {
            for (int j = G[i].indexOf(P[0]); j >= 0 && j <= G[0].length() - P[0].length(); j++) {
                if (G[i].substring(j, j + P[0].length()).equals(P[0])) {
                    baseSeroes.add(i);
                    baseGaroes.add(j);
                }
            }
        }

        for (int i = 0; i < baseSeroes.size(); i++) {
            List<String> result = new ArrayList<>();
            int baseSero = baseSeroes.get(i);

            for (int j = baseSero; j < baseSero + P.length; j++) {
                int baseGaro = baseGaroes.get(i);
                result.add(G[j].substring(baseGaro, baseGaro + P[0].length()));
            }

            if (Arrays.equals(P, result.toArray())) return "YES";
        }

        return "NO";
    }
}
