# Solution Idea
#   1. 

# time complexity :
##########################################################
# 입력
# 3
# 15
# 27
# 12
# 출력
# 27 15 12
##########################################################

n = int(input())

result =[]
for i in range(n):
    result.append(int(input()))

result = sorted(result, reverse=True)

for i in result:
    print(i, end=' ')