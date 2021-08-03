def solution(genres, plays):
    answer = []
    union_genres_plays = {}
    union_genres_plays_sum = {}
    plays_list = []

    # 장르:재생횟수 dic 생성 & 속한 노래가 많이 재생된 장르를 선택
    for i, j in enumerate(genres):
        if j in union_genres_plays.keys():
            union_genres_plays[j].append((plays[i], i))
            union_genres_plays_sum[j] += plays[i]
        else:
            union_genres_plays[j] = [(plays[i], i)]
            union_genres_plays_sum[j] = plays[i]

    # verse_dict = {v:k for k,v in union_genres_plays_sum.items()}
    # select_genre = verse_dict[max(verse_dict.keys())]

    # 재생횟수대로 정렬
    result = sorted(union_genres_plays_sum.items(), key=lambda x: -x[1])
    print(result)
    print(union_genres_plays)

    for key, value in union_genres_plays.items():
        union_genres_plays[key].sort(key=lambda x: (-x[0], x[1]))

    print(union_genres_plays)

    for i in result:
        if len(union_genres_plays[i[0]]) >= 2:
            answer.append(union_genres_plays[i[0]][0][1])
            answer.append(union_genres_plays[i[0]][1][1])
        else:
            answer.append(union_genres_plays[i[0]][0][1])

    # for key, value in result:
    #     union_genres_plays[key].sort(reverse=True)
    #     for i in union_genres_plays[key][:2]:
    #         answer.append(plays.index(i))

    # print(answer)
    return answer