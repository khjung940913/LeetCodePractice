class Solution:
    def countServers(self, grid: List[List[int]]) -> int:
        ROW, COL = len(grid), len(grid[0])
        rc = [0] * ROW
        cc = [0] * COL
        for i in range(ROW):
            for j in range(COL):
                if grid[i][j] == 1:
                    rc[i] += 1
                    cc[j] += 1
        
        c = 0
        for i in range(ROW):
            for j in range(COL):
                if grid[i][j] == 1 and (rc[i] > 1 or cc[j] > 1):
                    c += 1
        return c
