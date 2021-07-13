# Solution Idea
#   1. 

# time complexity :
##########################################################
# 입력
# 출력
##########################################################

# 하.... 시작도 못하곘어.........ㅠㅠ

from itertools import combinations
from collections import deque
import copy

n, m = map(int, input().split())
board = [] # 전체

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