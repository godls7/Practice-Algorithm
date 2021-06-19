# Solution Idea
#   1. 오름차순 정렬
#   2. 작은거 부터 하나씩 더해서 1000000 비교...?

# time complexity :
##########################################################
# 입력
# 5
# 3 2 1 1 9

# 출력
# 8
##########################################################

n = int(input())
money = list(map(int, input().split()))

money.sort()
result = 1

for i in money:
    if result < i:
        break;
    result += i

print(result)