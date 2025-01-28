class Solution:

    def __init__(self):
        self.localSum = 0

    def findMaxFish(self, grid: List[List[int]]) -> int:
        ROW, COL = len(grid), len(grid[0])
        visited = set()
        def dfs(i, j):
            if i < 0 or j < 0 or i >= ROW or j >= COL or \
                grid[i][j] == 0 or (i, j) in visited:
                return
            visited.add((i,j))
            self.localSum += grid[i][j]
            for ni, nj in [(i-1,j),(i+1,j),(i,j-1),(i,j+1)]:
                dfs(ni, nj)
            
        
        ans = 0
        for i in range(ROW):
            for j in range(COL):
                self.localSum = 0
                dfs(i, j)
                ans = max(ans, self.localSum)
        return ans
