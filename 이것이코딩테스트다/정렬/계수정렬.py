# 계수정렬
# time complexity : O(n + k)

arr = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8] # 기본 제공 배열

count = [0] * (max(arr)+1)

# 해당 인덱스 array에 넣어주기
for i in range(len(arr)):
    count[arr[i]] += 1

for j in range(len(count)):
    for k in range(count[j]):
        print(k, end='')