# 또해보기
# 모험가길드

# Solution Idea
#   1. 공포도가 낮은 사람부터 그룹화
#   2. 그리고 남은 공포도 높은 사람은 버려도 됨

# time complexity :
##########################################################
# 입력
# 5
# 2 3 1 2 2

# 출력
# 2
##########################################################

n = map(int, input())
scary = list(map(int, input().split()))

group = 0
# group_list = []
# index = 0
count = 0

scary.sort()
'''
for scare in scary:
    count = index
    for i in range(scary[index]):
        group_list.append(scary[count])
        if len(group_list) == i:
            break
        count += 1
    index += scare
    print(index)
    if index > len(scary):
        break;
    print(group_list)
    group_list.clear()
    group += 1
'''

for scare in scary:
    count += 1
    if count >= scare:
        group += 1
        count = 0

print(group)