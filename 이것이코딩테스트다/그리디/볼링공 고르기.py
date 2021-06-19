# Solution Idea
#   1. 공번호 = balls 리스트의 인덱스 + 1
#   2. 2개식 모든 조합구하고 같은 조합 제거

# time complexity :
##########################################################
# 입력
# 5 3
# 1 3 2 3 2
# 출력
# 8

# 입력
# 8 5
# 1 5 4 3 2 4 5 2
# 출력
# 25
##########################################################
import itertools

n,m = map(int, input().split())
balls = list(map(int, input().split()))

count=0
all_combi = list(itertools.combinations(balls,2))

count = len(all_combi)

for combi in all_combi:
    if combi[0] == combi[1]:
        count -= 1

print(count)