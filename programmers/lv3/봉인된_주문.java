//https://school.programmers.co.kr/learn/courses/30/lessons/389481#
import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        long delete = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (String ban : bans) {
            pq.add(convertNum(ban));
        }

        while (!pq.isEmpty() && pq.peek() <= n + delete) {
            pq.poll();
            delete++;
        }

        return convert(n + delete);
    }

    String convert(long n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int c = (int) ((n - 1) % 26 + 'a');
            sb.append((char) c);
            n = (n - 1) / 26;
        }
        return sb.reverse().toString();
    }

    long convertNum(String str) {
        long num = 0;
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - 'a' + 1;
            num = num * 26 + c;
        }
        return num;
    }
}
