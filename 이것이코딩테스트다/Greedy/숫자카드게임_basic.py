# 숫자카드게임
n,m = map(int, input().split())

result = 0
select = []

for i in range(n):
    data = list(map(int, input().split()))
    select.append(min(data))

result = max(select)

print(result)
