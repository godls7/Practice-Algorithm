def solution(people, limit):
    answer = 0

    people.sort()
    print(people)
    left = 0
    right = len(people) - 1

    while (left < right):
        if people[left] + people[right] <= limit:
            left += 1
            right -= 1
        else:
            right -= 1
        answer += 1

    if left == right:
        answer += 1
        print(1)

    print(answer)

    return answer