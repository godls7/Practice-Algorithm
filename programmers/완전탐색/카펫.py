def solution(brown, yellow):

    width = 0
    height = 0

    a = brown/2 + 2 # width + height
    b = brown + yellow # width * height

    for i in range(3, 5000): # i = width
        if b % i == 0:
            height = b//i
            if i+height == a:
                if i >= height:
                    return [i,height]
                else :
                    return [height, i]
                    
