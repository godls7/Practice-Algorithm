from collections import deque

def bfs(graph, start, visited):
    queue = deque(start) # 큐에 처음 노드 넣으면서 시작
    print(queue)

    visited[start] = True

    while True:
        v = queue.popleft() # 큐에서 맨앞꺼 뽑고
        print(v, end=" ")    

#각 노드가 연결된 정보를 list 자료형으로 표현(2차원 List)
graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 8],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7]
]

# 방문정보 자료형
visited = [False] * 9


bfs(graph, 1, visited)