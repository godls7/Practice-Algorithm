# 헤매다가 답지 참조....
# Solution Idea
#   1. 

# time complexity :
##########################################################
# 입력
2
5 6
0 0 1 0
# 출력
30
30

# 입력
3
3 4 5
1 0 1 0
# 출력
35
17
##########################################################

n = int(input())
number = list(map(int, input().split()))
add, sub, mul, div = map(int, input().split())

ans_min = 99999999999999999999
ans_max = -99999999999999999999

def dfs(i, now_number):
    global ans_max, ans_min, add, sub, mul, div

    if i == n: # 계산 다 했을때 
        ans_max = max(ans_max,now_number)
        ans_min = min(ans_min,now_number)
        
    else:
        if add > 0:
            add -= 1
            dfs(i+1, now_number + number[i])
            add += 1
        if sub > 0:
            sub -= 1
            dfs(i+1, now_number - number[i])
            sub += 1
        if mul > 0 :
            mul -= 1
            dfs(i+1, now_number * number[i])
            mul += 1
        if div > 0 :
            div -= 1
            dfs(i+1, int(now_number/number[i]))
            div += 1


dfs(1, number[0])

print(ans_max)
print(ans_min)