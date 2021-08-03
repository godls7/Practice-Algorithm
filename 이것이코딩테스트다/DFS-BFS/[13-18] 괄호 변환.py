# Solution Idea
#   1. 괄호는 스택!!!

# time complexity :
##########################################################
# 입력
"(()())()"
# 출력
"(()())()"

# 입력
")("
# 출력
"()"

# 입력
"()))((()"
# 출력
"()(())()"
##########################################################
# 문자열, u,v로 분리하는함수 - 갯수가 맞아야함
from typing import Tuple


def divide(input):
    start = 0
    end = 0

    for i in range(len(input)):
        if input[i] == '(':
            start += 1
        else:
            end += 1
        if start == end: # 개수 세다가,같으면 나눠서 리턴
            return input[:i+1], input[i+1:]

# 올바른 문자열 확인 - 짝이 맞아야함
def isCorrect(u):
    stack = []

    for part in u:
        if part == '(':
            stack.append(part)
        else :
            if not stack: # 스택에 아무것도 없는거 확인하는거 맞나..?
                return False
            stack.pop()

    return True

def solution(input):
    # 빈문자열 입력시, 빈문자열 반환
    if not input:
        return ''

    # 문자열 나누기
    u,v = divide(input)
    # print(u,v)

    # 올바른 문자열인지 확인
    if isCorrect(u):
        # 3-1
        return u + solution(v) 
    else: 
        # 4-1
        ans = '('
        # 4-2
        ans += solution(v)
        # 4-3
        ans += ')'
        # 4-4
        for part in u[1:len(u)-1]:
            if part == '(':
                ans += ')'
            else:
                ans += '('
            
        return print(ans)



solution("(()())()")
# solution(")(") # 얘만됨....
# solution("()))((()")