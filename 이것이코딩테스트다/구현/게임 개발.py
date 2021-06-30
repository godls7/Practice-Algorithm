# Solution Idea
#   1. 

# time complexity :
##########################################################
# 입력
# 4 4
# 1 1 0
# 1 1 1 1
# 1 0 0 1
# 1 1 0 1
# 1 1 1 1
# 출력
# 7
##########################################################

n,m = map(int, input().split())

# 방문자가 방문한 위치
position = [[0] * m for _ in range(n)]
# print(position)

# 현재위치 / 방향
x,y,dir = map(int,input().split())
position[x][y] = 1 # 현재위치 방문처리

# 맵 정보
now_map = []
for i in range(n):
    now_map.append(list(map(int, input().split())))

# (a,b) : a:북쪽으로부터 떨어진 칸개수 / b:서쪽으로부터떨어진 칸개수
dx = [-1,0,1,0] # 북 동 남 서
dy = [0,1,0,-1]

# 회전
def rotation():
    global dir
    dir -= 1
    if dir == -1:
        dir = 3

count = 1
t_time = 0 # 회전 시간

while True:
    rotation()
    nx = x + dx[dir]
    ny = y + dy[dir]

    # 정면에 갈 수 잇는 경우?
    if position[nx][ny] == 0 and now_map[nx][ny] == 0 :
        position[nx][ny] = 1
        x = nx
        y = ny
        count += 1
        t_time = 0
        continue
    # 정면에 다 가봤거나 바다 인경우
    else:
        t_time += 1
        
    # 네방향 다 갈수 없는 경우
    if t_time == 4 :
        nx = x - dx[dir]
        ny = y - dy[dir]
        # 뒤로 갈 수 있으면 이동?
        if now_map[nx][ny] == 0:
            x = nx
            y = ny
        # 뒤가 바다 인경우
        else:
            break
        t_time = 0

print(count)