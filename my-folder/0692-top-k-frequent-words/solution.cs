using System.Collections.Generic;

public class Solution {

    class WordPriority : IComparable<WordPriority> {
        public int freq;
        public String word;

        public WordPriority(int freq, string word) {
            this.freq = freq;
            this.word = word;
        }

        public int CompareTo(WordPriority other) {
            int cmp = this.freq.CompareTo(other.freq);
            if (cmp != 0) return -cmp;
            return this.word.CompareTo(other.word);
        }
    }

    public IList<string> TopKFrequent(string[] words, int k) {
        Dictionary<string, int> countMap = new Dictionary<string, int>();
        foreach(string w in words) {
            if (!countMap.ContainsKey(w)) countMap[w] = 0;
            countMap[w] += 1;
        }

        PriorityQueue<string,WordPriority> pq = new PriorityQueue<string, WordPriority>();
        foreach(var kv in countMap) {
            pq.Enqueue(kv.Key, new WordPriority(kv.Value, kv.Key));
        }

        List<string> ans = new List<string>();
        while (k > 0) {
            ans.Add(pq.Dequeue());
            k--;
        }
        return ans;
    }
}
