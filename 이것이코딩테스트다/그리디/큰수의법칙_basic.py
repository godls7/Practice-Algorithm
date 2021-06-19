# 큰 수의 법칙
n,m,k = map(int, input().split())
data = list(map(int, input().split()))

data.sort()
max1 = data[n-1]
max2 = data[n-2]

while True:
    for number in range(k):
        if m == 0:
            break;
        result += max1
        m -= 1
    if m == 0:
        break;
    result += max2
    m -= 1

print(result)