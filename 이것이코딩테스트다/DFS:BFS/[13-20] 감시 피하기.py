# Solution Idea
#   1. 

# time complexity :
##########################################################
# 입력

# 건형님 코드
# 무조건다시
from collections import deque
from itertools import combinations
import copy
from sys import flags

n = int(input())
way = []

# input
for _ in range(n):
    cols = list(input().split())
    way.append(cols)

# init
dx = [-1, 0, 1, 0]      # 북, 동, 남, 서
dy = [0, 1, 0, -1]
pos_teacher = []        # 선생님의 위치
pos_empty   = []        # 비어 있는 위치

for i in range(n):
    for j in range(n):
        if way[i][j] == 'T':
            pos_teacher.append((i, j, 0))
            pos_teacher.append((i, j, 1))
            pos_teacher.append((i, j, 2))
            pos_teacher.append((i, j, 3))
        elif way[i][j] == 'X':
            pos_empty.append((i, j))

cases = list(combinations(pos_empty, 3))

def bfs(case_wall):
    queue = deque(pos_teacher)
    _way = copy.deepcopy(way)

    while queue:
        x, y, dir = queue.popleft()
            
        nx = x + dx[dir]
        ny = y + dy[dir]

        if not ((0 <= nx < n) and (0 <= ny < n)): continue
        if (nx, ny) in case_wall: continue          # O : 장애물 3곳
        if _way[nx][ny] == "T": continue
        if _way[nx][ny] == "S":
            return "NO"

        _way[nx][ny] = "T"
        queue.append((nx, ny, dir))
                
    return "YES"


for case_wall in cases:
    if bfs(case_wall) == "YES":
        flag = "YES"
        break
    else:
        flag = "NO"

print(flag)