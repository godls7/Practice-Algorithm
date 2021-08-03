from collections import deque

def bfs(graph, start, visited):
    # 주의! deque 삽입시 [] 로 넣어야함
    queue = deque([start]) # 큐에 처음 노드 큐에 넣으면서 시작 #
    # print(queue)

    visited[start] = True

    while queue: # 큐에 값이 있을동안
        v = queue.popleft() # 큐에서 맨앞꺼 뽑고
        print(v, end=" ")

        for i in graph[v]: # 해당 노드의 인접노드들 확인
            # print(i)
            if not visited[i]: # 방문하지 않았으면
                queue.append(i) # 큐에 넣자
                visited[i] = True # 그리고 방문처리

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