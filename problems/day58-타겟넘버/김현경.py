def solution(numbers, target):
    answer = 0
    n = len(numbers)
    
    def dfs(idx, sum):
        if idx == n:
            if  sum == target:
                return 1
            return 0
            return
        plus = dfs(idx+1, sum+numbers[idx])
        minus = dfs(idx+1, sum-numbers[idx])
        return plus+minus
    answer = dfs(0,0)
    return answer