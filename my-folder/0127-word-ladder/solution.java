import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        if (beginWord.equals(endWord)) return 1;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int len = 1;
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int s = 0; s < levelSize; s++) {
                String curr = q.poll();
                if (curr.equals(endWord)) return len;

                char[] arr = curr.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char orig = arr[i];
                    for (char c : alphabet) {
                        if (c == orig) continue;
                        arr[i] = c;
                        String next = new String(arr);
                        if (next.equals(endWord)) return len + 1;
                        if (dict.contains(next) && visited.add(next)) {
                            q.add(next);
                        }
                    }
                    arr[i] = orig;
                }
            }
            len++;
        }
        return 0;
    }
}

