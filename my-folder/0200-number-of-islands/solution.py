class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        visited = [[False for _ in range(len(grid[0]))] for _ in range(len(grid))]
        def dfs(i,j):
            if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]):
                return
            if visited[i][j] or grid[i][j] == "0":
                return
            visited[i][j] = True
            dfs(i-1,j)
            dfs(i+1,j)
            dfs(i,j-1)
            dfs(i,j+1)

        ans = 0
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if not visited[r][c] and grid[r][c] == "1":
                    ans += 1
                    dfs(r, c)
        return ans
            
