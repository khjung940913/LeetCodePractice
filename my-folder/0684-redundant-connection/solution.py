class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        graph = defaultdict(list)
        for edge in edges:
            graph[edge[0]].append(edge[1])
            graph[edge[1]].append(edge[0])
        

        def hasCycle(orig, cur, visited, l):
            if cur in visited:
                return l > 2 and cur == orig
            
            r = False
            visited.add(cur)
            for g in graph[cur]:
                r = r or hasCycle(orig, g, visited, l + 1)
            return r

        for edge in reversed(edges):
            visited = set()
            visited.add(edge[0])
            if hasCycle(edge[0], edge[1], visited , 1):
                return edge
        return [-1, -1]
            

