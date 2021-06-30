from collections import deque

# 크기 / 바이러스수
n, k = map(int, input().split())

graph = []
virus_list = []

for i in range(n):
    # 현재 바이러스 위치
    graph.append(list(map(int, input().split())))

    # 존재하면, 바이러스 종류, 위치저장
    for j in range(n): 
        if graph[i][j] != 0:
            virus_list.append((graph[i][j],0,i,j))
                         # 종류 / 시간 / x / y 

s,x,y = map(int, input().split())
# print(graph)
# print(virus)
# print(virus_list)

virus_list.sort()
queue = deque(virus_list)
# print(queue)
# queue.append(virus_list)
# print(queue)

# print(queue)



# 상하좌우
dx = [-1,1,0,0]
dy = [0,0,-1,1]


while queue:
    # print('hello')
    virus,time,v_x,v_y = queue.popleft()
    # print(time)

    # 시간이 넘으면..?
    if s == time:
        break

    for i in range(4):
        nx = v_x + dx[i]
        ny = v_y + dy[i]

        if nx >= 0 and nx < n and ny >= 0 and ny < n: 
            if graph[nx][ny] == 0:
                graph[nx][ny] = virus
                queue.append((virus,time+1,nx,ny))
                
    
if graph[x-1][y-1] == 0:
    print(0)

print(graph[x-1][y-1])