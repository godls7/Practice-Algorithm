# Solution Idea
#   1. 

# time complexity :
##########################################################
# 입력
# 출력
##########################################################

from collections import deque

# 도시/도로/거리/출발도시
n,m,k,x = map(int, input().split())
graph = [[] for _ in range(n+1)] # 0/ 1~4

for _ in range(m):
    a,b = map(int, input().split())
    graph[a].append(b)

# print(graph)

distance = [-1] * (n+1)
distance[x] = 0 # 출발지 

queue = deque()
queue.append(x)

while queue:
    now = queue.popleft()
    
    for next in graph[now]:
        if distance[next] == -1:
            distance[next] = distance[now] + 1
            queue.append(next)

# print(distance)

if k in distance:
    for i in range(1,n+1):
        if distance[i] == k:
            print(i)
else:
    print(-1)
    
