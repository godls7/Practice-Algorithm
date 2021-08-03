def dfs(computers, visited, v):
    if not visited[v]:
        visited[v] = True
    
    for i in range(len(computers)):
        if computers[v][i] == 1 and not visited[i]:
            dfs(computers, visited, i)


def solution(n, computers):
    answer = 0
    visited = [False] * n
    print(visited)
    
    while False in visited:
        for i in range(n):
            if not visited[i]:
                dfs(computers, visited, i)
                answer += 1
    return answer

print(solution(3, [[1, 1, 0], [1, 1, 0], [0, 0, 1]]))