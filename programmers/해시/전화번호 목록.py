def solution(phone_book):
    answer = True

    phone_book.sort()
    # r_phone_book = reversed(phone_book)

    zip_phone = list(zip(phone_book, phone_book[1:]))

    # print(zip_phone)

    for p1, p2 in zip_phone:
        if p2.startswith(p1):
            return False

    # 효율성 테스트 실패
    # for i in range(len(phone_book)):
    #     for j in range(i+1,len(phone_book)):
    #         if phone_book[j].startswith(phone_book[i]) == True:
    #             answer = False
    #             break

    return answer