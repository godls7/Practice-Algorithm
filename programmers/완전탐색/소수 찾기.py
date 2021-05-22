from itertools import permutations
from math import sqrt

def solution(numbers):
    answer = 0

    allnumber = []
    answer = set()

    for i in range(len(numbers)):
        tmp = list(permutations(numbers,i+1))
        for j in tmp:
            if isprime(int(''.join(j))):
                answer.add(int(''.join(j)))
    return len(answer)

def isprime(number):
    if number < 2:
        return False
    for i in range(2, int(sqrt(number)+1)):
        if number % i == 0:
            return False
    return Trues
