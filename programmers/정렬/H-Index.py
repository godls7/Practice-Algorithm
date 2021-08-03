def solution(citations):

    citations.sort(reverse=True)
    print(citations)
    for i,n in enumerate(citations):
        if n <= i:
            return i

    return len(citations)

    '''
    answer = 0

    h = 0
    h_paper = []

    for i in range(len(citations)):
        h = int(sum(citations)/len(citations))
        if citations[i] >= h:
            h_paper.append(citations[i])
    print(h_paper)
    '''

    return answer
