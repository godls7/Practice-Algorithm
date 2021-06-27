from collections import deque

# BFS 메서드 정의
def bfs(graph, v, visited):

    # queue = deque([v])
    queue = deque()
    queue.append(v)

    visited[v] = True

    # 큐가 빌 때까지
    while queue:
        v = queue.popleft()
        print(v, end=' ')

        for node in graph[v]:
            if not visited[node]:
                visited[node] = True    
                queue.append(node)
        

#각 노드가 연결된 정보를 list 자료형으로 펴햔(2차원 List)
graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7]
]

# 각 노드가 방문된 정보를 list 자료형으로 표현(1차원 List)
visited = [False] * 9

# 정의된 BFS 함수 호출
bfs(graph, 1, visited)