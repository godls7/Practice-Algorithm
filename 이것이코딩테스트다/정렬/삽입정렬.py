# 삽입정렬
# time complexity : O(n^2)
# 이미 어느정도(거의) 정렬이 되어 있다면 O(n) (최선의 경우) 까지 나온다

arr = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8] # 기본 제공 배열
# arr = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]
# arr = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]
# arr = [0, 5, 7, 9, 3, 1, 6, 2, 4, 8]

for i in range(len(arr)):
    for j in range(i,0,-1):
        if arr[j] < arr[j-1]:
            arr[j], arr[j-1] = arr[j-1], arr[j]
        else:
            break
            
print(arr)

