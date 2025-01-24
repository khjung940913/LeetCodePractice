class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        N = len(graph)
        safe = {}
        def dfs(i):
            if i in safe:
                return safe[i]
            safe[i] = False
            for n in graph[i]:
                if not dfs(n):
                    return safe[i]
            safe[i] = True
            return safe[i]
        
        ret = []
        for i in range(N):
            if dfs(i):
                ret.append(i)
        return ret
