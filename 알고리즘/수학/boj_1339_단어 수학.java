 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-07
  * URL   : https://www.acmicpc.net/problem/1339
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Map<Character, Integer> alphabet = new HashMap<>();

        for (int i = 0; i < K; i++) {
            String word = br.readLine();
            int pos = (int)Math.pow(10, word.length()-1);

            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                alphabet.put(ch, alphabet.getOrDefault(ch, 0) + pos);
                pos /= 10;
            }
        }

        List<Map.Entry> list = new ArrayList<>(alphabet.entrySet());
        Collections.sort(list, (o1, o2) -> Integer.compare((int)o2.getValue(), (int)o1.getValue()));

        int sum = 0;
        int max = 9;
        for (Map.Entry map : list) {
            sum += (int)map.getValue() * max--;
        }

        System.out.println(sum);
    }

}