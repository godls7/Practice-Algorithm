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

# 짝수 : n//2 -1
# 홀수 : n//2
n = int(input())
house = list(map(int, input().split()))

house.sort()
all_dis = []

# for i in range(n):
#     dis = 0
#     for j in range(n):
#         dis += abs(house[j] - house[i])
#     all_dis.append(dis)

index = n%2 == 0 and n//2 -1 or n//2
# 앞에꺼 맞으면 2, 아니면 3
print(house[index])

# print(house[all_dis.index(min(all_dis))])