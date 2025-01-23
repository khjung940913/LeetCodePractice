class Solution:
    def trapRainWater(self, heightMap: List[List[int]]) -> int:
        ROW, COL = len(heightMap), len(heightMap[0])
        min_heap = []
        for i in range(ROW):
            for j in range(COL):
                if i in [0, ROW - 1] or j in [0, COL - 1]:
                    heappush(min_heap, (heightMap[i][j], i, j))
                    heightMap[i][j] = -1
        
        m_h = -1
        ret = 0
        while min_heap:
            h, r, c = heappop(min_heap)
            m_h = max(m_h, h)
            ret += m_h - h
            for nr, nc in [(r-1,c),(r+1,c),(r,c-1),(r,c+1)]:
                if nr < 0 or nc < 0 or nr >= ROW or nc >= COL or heightMap[nr][nc] == -1:
                    continue
                heappush(min_heap, (heightMap[nr][nc], nr, nc))
                heightMap[nr][nc] = -1
        return ret
