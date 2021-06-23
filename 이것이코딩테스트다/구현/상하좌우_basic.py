n = int(input())
plans = input().split()

dx = [0,0,-1,1]
dy = [-1,1,0,0]

all_dir = ['L','R','U','D']

x,y = 1,1

for plan in plans:
    for i in range(len(all_dir)):
        if plan == all_dir[i]:
            x += dx[i]
            y += dy[i]
            break

    if x>n or x<1 or y>n or y<1:
        # 주의!
        # 꼭 빼줘야함!
        x -= dx[i]
        y -= dy[i]
        pass

print(x,y)