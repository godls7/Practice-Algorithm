def fibonachi(n):
    #  n = (n-1) + (n-2)
    
    if n < 2:
        return n
    return fibonachi(n-2) + fibonachi(n-1)
    
print(fibonachi(6))