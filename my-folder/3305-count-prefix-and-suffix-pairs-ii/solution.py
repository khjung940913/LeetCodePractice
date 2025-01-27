class TrieNode:
    def __init__(self):
        self.children = {}
        self.count = 0


class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def add(self, word):
        cur = self.root
        for c1, c2 in zip(word, reversed(word)):
            if (c1, c2) not in cur.children:
                cur.children[(c1, c2)] = TrieNode()
            cur = cur.children[(c1, c2)]
            cur.count += 1
    
    def count(self, word):
        cur = self.root
        for c1, c2 in zip(word, reversed(word)):
            if (c1, c2) not in cur.children:
                return 0
            cur = cur.children[(c1, c2)]
        return cur.count

class Solution:
    def countPrefixSuffixPairs(self, words: List[str]) -> int:
        c = 0
        trie = Trie()
        for word in reversed(words):
            c += trie.count(word)
            trie.add(word)
        return c
