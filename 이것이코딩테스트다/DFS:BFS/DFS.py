# DFS 메서드 정의
# 스택 혹은 재귀
def dfs(graph, v, visited):
    
    visited[v] = True # 첫방문 방문처리
    print(v, end='')

    # graph 인덱스 + 1 = 실제 노드
    for part in graph[v]:
        # print(part)
        if not visited[part]:
            dfs(graph, part, visited)
        
    # print()

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

# 각 노드가 방문된 정보를 list 자료형으로 표현(1차원 List)
visited = [False] * 9

# 정의된 DFS 함수 호출
dfs(graph, 1, visited)