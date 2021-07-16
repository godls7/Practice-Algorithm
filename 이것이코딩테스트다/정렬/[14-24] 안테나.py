# Solution Idea
#   1. 

# time complexity :
##########################################################
# 입력
# 4
# 5 1 7 9

# 출력
# 5
##########################################################

n = int(input())
house = list(map(int, input().split()))

all_dis = []
poisition = 0

for i in range(n):
    dis = 0
    for j in range(n):
        dis += abs(house[j] - house[i])
    all_dis.append(dis)

print(house[all_dis.index(min(all_dis))])