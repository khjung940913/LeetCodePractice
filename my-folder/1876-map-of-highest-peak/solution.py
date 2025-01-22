class Solution:
    def highestPeak(self, isWater: List[List[int]]) -> List[List[int]]:
        ROW, COL = len(isWater), len(isWater[0])
        q = deque()
        visited = set()
        res = [[-1]*COL for _ in range(ROW)]
        for i in range(ROW):
            for j in range(COL):
                if isWater[i][j] == 1:
                    q.append((i, j))
                    visited.add((i,j))
                    res[i][j] = 0
        
        # bfs
        while q:
            r,c = q.popleft()
            neigh = [(r-1,c),(r+1,c),(r,c-1),(r,c+1)]
            for nr, nc in neigh:
                if nr < 0 or nc < 0 or nr == ROW or nc == COL or (nr, nc) in visited:
                    continue
                q.append((nr, nc))
                visited.add((nr, nc))
                res[nr][nc] = res[r][c] + 1
        return res
