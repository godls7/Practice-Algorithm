position = input()
row = int(position[1])

# ASCII => a : 97
# ord('a') : ASCII 코드값 출력
colunms = {'a':1,'b':2,'c':3,'d':4,'e':5,'f':6,'g':7,'h':8}
col = colunms[position[0]]

moves = [(-2,1),(-2,-1),(2,1),(2,-1),(1,2),(1,-2),(-1,2),(-1,-2)]

count = 0

for move in moves:
    x = col + move[0]
    y = row + move[1]

    if x<1 or x>8 or y<1 or y>8:
        continue

    count += 1

print(count)