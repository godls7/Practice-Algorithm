# Solution Idea
#   1. 

# time complexity :
##########################################################
# 입력
# 5 3
# 1 2 5 4 3
# 5 5 6 6 5
# 출력
##########################################################

n,k = map(int, input().split())
list1 = list(map(int, input().split()))
list2 = list(map(int, input().split()))

list1.sort()
list2.sort(reverse=True)

for i in range(k):
    list1[i] = list2[i]

result = 0
for i in list1:
    result += i

print(result)