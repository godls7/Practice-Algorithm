def solution(n, lost, reserve):
    answer = 0

    # 도난 당했지만 여벌옷 있는 사람 제거
    reserve_del = list(set(reserve) - set(lost))
    lost_del = list(set(lost) - set(reserve))

    answer = n - len(lost_del)
    for i in lost_del:
        if i - 1 in reserve_del:
            answer += 1
            reserve_del.remove(i - 1)
        elif i + 1 in reserve_del:
            answer += 1
            reserve_del.remove(i + 1)

    return answer