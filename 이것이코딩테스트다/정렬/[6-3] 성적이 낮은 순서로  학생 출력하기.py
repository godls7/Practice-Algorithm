# Solution Idea
#   1. 

# time complexity :
##########################################################
# 입력
# 2
# 홍길동 95
# 이순신 77
# 출력
# 이순신 홍길동
##########################################################

n = int(input())
array = []

for i in range(n):
    memeber = input().split()
    array.append((memeber[0],int(memeber[1])))

result = sorted(array, key=lambda data:data[1])

for i in range(n):
    print(result[i][0], end=' ')