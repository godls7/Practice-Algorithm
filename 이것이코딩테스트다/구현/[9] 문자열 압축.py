# Solution Idea
#   1. 

# time complexity :
##########################################################
# 입력
# 'aabbaccc'
# 출력
# 7

# 입력
# 'ababcdcdababcdcd'
# 출력
# 9
##########################################################

def solution(s):
    answer = len(s)
    string_len = len(s)

    # 전체 길이에 반만큼 반복하면..
    for i in range(1, (string_len // 2 + 1)):
        part_string = s[0:i]  # 처음 부분 문자열은 이미 저장..?
        # print()
        # print('문자열 개수', i)
        # print('part :', part_string)

        # 같은 문자열 개수 세기
        count = 1
        compress = ''

        # 두번째 문자열 파트 부터 문자열 끝까지 i 간격으로 비교..?
        for j in range(i, string_len, i):
            # print('part-2', s[j:j + i])
            # 이전과 동일
            if part_string == s[j:j + i]: 
                count += 1
            # 이전과 다른 문자열
            else:
                if count != 1:
                    compress = compress + str(count) + part_string
                else:
                    compress += part_string
                part_string = s[j:j+i]
                count = 1 # 초기화
        
        if count != 1:
            compress = compress + str(count) + part_string
        else:
            compress += part_string
        
        answer = min(answer, len(compress))

    return answer

print(solution("ababcdcdababcdcd"))