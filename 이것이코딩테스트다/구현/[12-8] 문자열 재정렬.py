# Solution Idea
#   1. 문자와 숫자 나눔
#   2. 문자 오름차순정렬 / 숫자더해서 문자열로 합치기

# !!!! 문자열 접근시, 문자열이 계속 바뀌게 되면 인덱스 접근 주의!!
# 값을 다른 변수에 copy 해서 사용해야함!!

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
import copy

# 두번째 예시 안됨...
string = list(input())

dight = str([0,1,2,3,4,5,6,7,8,9])
number = 0

copy_s = copy.deepcopy(string)

# print(string)

for i in copy_s:
    # print('문자',i, end=' ')
    if i in dight:
        # print('숫자',i)
        number += int(i)
        string.remove(i)
        print(string)

result = ''.join(sorted(string)) + str(number)
print(result)