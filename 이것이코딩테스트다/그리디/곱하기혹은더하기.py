# Solution Idea
#   1. 0이 아니면 곱하기
#   2. 0이면 더하기

# time complexity :
##########################################################
# 입력
# 02984
# 출력
# 576

# 입력
# 567
# 출력
# 210
##########################################################
n = list(map(int,input()))

# 1차 풀이
'''
result = 1

for i in n:
    if i == 0:
        result += i
    else :   
        result *= i
print(result)
'''

# 2차 풀이
result = n[0]
for i in range(1,len(n)):
    num = n[i]
    if num == 0 or num == 1:
        result += num
    else:
        result *= num

print(result)