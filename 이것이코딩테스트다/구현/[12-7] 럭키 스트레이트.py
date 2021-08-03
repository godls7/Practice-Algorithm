# Solution Idea
#   1. 앞부분 더하고 뒷부분 더하고 비교

# time complexity :
##########################################################
# 입력
# 123402
# 출력
# LUCKY

# 입력
# 7755
# 출력
# READY
##########################################################

scores = list(map(int,input()))

front ,back = 0,0
len = len(scores)

for i in range(int(len/2)):
    front += scores[i]
    back += scores[len-1]

if front == back:
    print('LUCKY')
else:
    print('READY')