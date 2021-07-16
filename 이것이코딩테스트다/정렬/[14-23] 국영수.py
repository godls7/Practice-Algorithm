# Solution Idea
#   1. 

# time complexity :
##########################################################
# 입력
# 12
# Junkyu 50 60 100
# Sangkeun 80 60 50
# Sunyoung 80 70 100
# Soong 50 60 90
# Haebin 50 60 100
# Kangsoo 60 80 100
# Donghyuk 80 60 100
# Sei 70 70 70
# Wonseob 70 70 90
# Sanghyun 70 70 90
# nsj 80 80 80
# Taewhan 50 60 90

# 출력
##########################################################

n = int(input())
students = []

for i in range(n):
    student = input().split()
    students.append(student)

students = sorted(students, key=lambda data:(-int(data[1]), int(data[2]), -int(data[3]), data[0]))


for i in range(n):
    print(students[i][0])