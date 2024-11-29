class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if not board:
            return True
        rowSet = defaultdict(set)
        colSet = defaultdict(set)
        threeByThreeSet = defaultdict(lambda: defaultdict(set))
        r = len(board)
        c = len(board[0])
        for i in range(r):
            for j in range(c):
                if board[i][j].isalnum():
                    if board[i][j] in rowSet[i]:
                        return False
                    rowSet[i].add(board[i][j])
                    if board[i][j] in colSet[j]:
                        return False
                    colSet[j].add(board[i][j])
                    ti = i // 3
                    tj = j // 3
                    if board[i][j] in threeByThreeSet[ti][tj]:
                        return False
                    threeByThreeSet[ti][tj].add(board[i][j])
        return True
                
