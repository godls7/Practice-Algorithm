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

#1
# result = sorted(result, reverse=True)

#2
# result.sort(reverse=True)

#3
result.sort(key=lambda data:-data)

for i in result:
    print(i, end=' ')