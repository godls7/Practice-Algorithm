# Solution Idea
#   1. 문자와 숫자 나눔
#   2. 문자 오름차순정렬 / 숫자더해서 문자열로 합치기

# time complexity :
##########################################################
# 입력
# K1KA5CB7
# 출력
# ABCKK13

# 입력
# AJKDLSI412K4JSJ9D
# 출력
# ADDIJJJKKLSS20
##########################################################

# 두번째 예시 안됨...
string = list(input())

dight = str([0,1,2,3,4,5,6,7,8,9])
number = 0

for i in string:
    # print(i)
    if i in dight:
        # print(i)
        number += int(i)
        string.remove(i)

result = ''.join(sorted(string)) + str(number)
print(result)