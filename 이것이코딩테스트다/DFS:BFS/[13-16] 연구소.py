# Solution Idea
#   1. 

# time complexity :
##########################################################
# 입력
# 7 7
'''
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
'''
# 출력
##########################################################

# 하.... 시작도 못하곘어.........ㅠㅠ
# 건형님 코드

from itertools import combinations
from collections import deque
import copy

n, m = map(int, input().split())
board = []

# init
for _ in range(n):
    cols = list(map(int, input().split()))
    board.append(cols)

empty_list   = [] # 비어 있는 좌표
wall_list    = [] # 벽이 있는 좌표
virus_list   = [] # 바이러스가 있는 좌표
dx           = [-1, 0, 1, 0]
dy           = [0, 1, 0, -1]

for i in range(n):
    for j in range(m):
        pos = board[i][j]
        if pos == 0:    # 비어 있는 곳
            empty_list.append((i, j))
        elif pos == 1:  # 벽이 있는 곳
            wall_list.append((i, j))
        else:           # 바이러스가 있는 곳
            virus_list.append((i, j))

cases = list(combinations(empty_list, 3))

def bfs(case_wall):
    queue = deque(virus_list)
    _board = copy.deepcopy(board)
    cnt_virus = 0

    while queue:
        x, y = queue.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if not ((0 <= nx < n) and (0 <= ny < m)): continue
            if (nx, ny) in case_wall: continue # case_wall : 3 곳의 벽
            if _board[nx][ny] == 2: continue
            if _board[nx][ny] == 1: continue

            _board[nx][ny] = 2
            cnt_virus += 1
            queue.append((nx, ny))

            # for a in _board:
            #     print(a)
            # print()
    
    return cnt_virus

# 전체 - 벽의 갯수 - 바이러스 갯수 - 3개의 추가 벽
total = (n * m) - len(wall_list) - len(virus_list) - 3
max_safe_area = 0

for case_wall in cases:
    cnt_virus = bfs(case_wall)
    max_safe_area = max(max_safe_area, total-cnt_virus)
    
print(max_safe_area)