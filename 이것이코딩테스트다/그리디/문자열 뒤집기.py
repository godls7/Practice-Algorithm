# Solution Idea
#   1. 0 / 1 바꾸는 경우 나눠서 카운트

# time complexity :
##########################################################
# 입력
# 0001100

# 출력
# 1
##########################################################

string = list(map(int, input()))

change_0 = 0
change_1 = 0

if string[0] == 0:
    change_1 += 1
else:
    change_0 += 1

for i in range(len(string)-1):
    if string[i] != string[i+1]:
        if string[i+1] == 0:
            change_1 += 1
        else:
            change_0 += 1

print(min(change_0,change_1))