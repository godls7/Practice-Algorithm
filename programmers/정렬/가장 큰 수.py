from itertools import permutations

def solution(numbers):

    answer = ''
    numbers = list(map(str, numbers)) # number 수를 str으로 바꿈

    numbers.sort(key=lambda x: x*3, reverse=True) # 1000 이하로 맞춤

    # 문자열 숫자 대소비교??
    return str(int(''.join(numbers)))

# 시간초과 망해버림...
'''
def solution(numbers):
    answer = ''
    allNumList = []
    setNumbers = list(permutations(numbers)) # 총 순열 리스트

    # 모든 순열 경우 가진 list 생성
    for i in range(len(setNumbers)):
        eachNumList = list(map(str,setNumbers[i]))
        a = "".join(eachNumList)
        allNumList.append(a)

    answer = sorted(allNumList)[-1]

    return answer
'''
