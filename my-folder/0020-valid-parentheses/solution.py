class Solution:
    def isValid(self, s: str) -> bool:
        m = {
            ')' : '(',
            '}' : '{',
            ']' : '['
        }
        stack = []
        for c in s:
            if c == '(' or c == '{' or c == '[':
                stack.append(c)
            if c == ')' or c == '}' or c == ']':
                if len(stack) == 0 or stack.pop() != m[c]:
                    return False
        
        return len(stack) == 0
        
