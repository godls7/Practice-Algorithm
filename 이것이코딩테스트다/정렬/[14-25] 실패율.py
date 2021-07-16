# Solution Idea
#   1. 

# time complexity :
##########################################################
# 입력
# 출력
##########################################################

def solution(N, stages):
    answer = []
    fail_rate = []

    # 1번 스테이지부터
    for i in range(1,N+1):
        clear_player = 0
        noclear_player = 0

        # 플레이어 한명씩 확인
        for j in range(len(stages)):
            if i <= stages[j]:
                clear_player += 1
                if i == stages[j]:
                    noclear_player += 1
        
        # 스테이지 도달한 유저 없는 경우 실패율=0
        if noclear_player == 0:
            fail_rate.append((i,0))
            continue
        # print(clear_player,noclear_player)
        fail_rate.append((i,noclear_player/clear_player))

    result = sorted(fail_rate, key=lambda rate:-rate[1])
    
    for i in range(N):
        answer.append(result[i][0])
    
    return answer


# print(solution(5, [2,1,2,6,2,4,3,3]))
# [3, 4, 2, 1, 5]
print(solution(4,[4,4,4,4,4]))
# [4, 1, 2, 3]