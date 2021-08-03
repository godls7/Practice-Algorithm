def solution(clothes):
    answer = 1

    items = {}

    # 모든 items 딕셔너리 생성
    for thing in clothes:
        key = thing[1]
        value = thing[0]
        if key in items:
            items[key].append(value)
        else:
            items[key] = [value]

    # 가능한 모든 조합 구하기
    for key in items.keys():
        answer *= len(items[key]) + 1

    return answer - 1