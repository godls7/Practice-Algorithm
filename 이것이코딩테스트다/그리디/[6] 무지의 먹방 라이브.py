# Solution Idea
#   1. n이 k로 나누어질 때
#   2. 아니면 n에서 1을 뺸다

# time complexity :
##########################################################
# 입력
# [3,1,2]
# 5

# 출력
# 1
##########################################################

food_times = [3,1,2]
k = 5

loop = len(food_times)
error = 0

while True:
    for i in range(k):
        food_times[i] -= 1