def dfs(graph, v, visited): # 그래프 / 현재노드 / 방문처리
    visited[v] = True # 현재노드 방문처리
    print(v, end=' ')

    # 현재노드에 인접해있는 노드 차례대로 방문
    for i in graph[v] :
        if not visited[i] : # 만약 인접노드가 아직 방문하지 않았다면
            dfs(graph, i , visited) # 해당 인접노드로 다시 방문

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

dfs(graph, 1, visited)