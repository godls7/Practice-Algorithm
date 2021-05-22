def solution(answers):

    answer1 = [1, 2, 3, 4, 5] # 1번 답 패턴 - 5개
    answer2 = [2, 1, 2, 3, 2, 4, 2, 5] # 2번 답 패턴 - 8개
    answer3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] # 3번 답 패턴 - 10개

    score = [0,0,0]

    for i in range(len(answers)):
        if answers[i] == answer1[i%5]: # 정답과 1번 답 비교
            score[0] += 1

        if answers[i] == answer2[i%8]: # 정답과 2번 답 비교
            score[1] += 1

        if answers[i] == answer3[i%10]: # 정답과 3번 답 비교
            score[2] += 1

    winner = []
    for i in range(3):
        if score[i] == max(score): # 가장 높은 점수 맞은 사람 출력
            winner.append(1+i)

    return winner
