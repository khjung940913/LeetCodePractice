class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        graph = defaultdict(list)
        for preq in prerequisites:
            graph[preq[1]].append(preq[0])
        
        def dfs(u, cur, visited):
            if cur == u:
                return True
                    
            res = False
            for n in graph[cur]:
                if n not in visited:
                    visited.add(n)
                    res = res or dfs(u, n, visited)
            return res

        ans = []
        for q in queries:
            visited = set()
            ans.append(dfs(q[0], q[1], visited))

        return ans
