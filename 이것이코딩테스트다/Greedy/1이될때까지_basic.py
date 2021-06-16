# 1이 될때 까지

# Solution Idea
#   1. n이 k로 나누어질 때
#   2. 아니면 n에서 1을 뺸다

# time complexity :
##########################################################
# 입력
# 25 5

# 출력
# 2
##########################################################

n,k = map(int, input().split())

count = 0

while n>1:
    if n%k == 0:
        n = n//k
    else:
        n -= 1
    count += 1

print(count)