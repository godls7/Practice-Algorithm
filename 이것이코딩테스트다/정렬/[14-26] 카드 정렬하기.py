# Solution Idea
#   1. 

# time complexity :
##########################################################
# 입력
# 3
# 10
# 20
# 40

# 출력
# 100
##########################################################

n = int(input())

card = []
for i in range(n):
    card.append(int(input()))

card.sort()

count = 0
for i in range(n):
    if i == 0:
        count += (card[i]+card[i+1])
    elif i >= 2:
        count += (card[i-2]+card[i-1]+card[i])

print(count)