def solution(participant, completion):
    count = {}

    # 동일이름 수 확인
    for n in participant:
        try:
            count[n] += 1
        except:
            count[n] = 1

    # print(count)

    for i in completion:
        if count[i] == 1:
            del count[i]
        else:
            count[i] -= 1

    return list(count.keys())[0]