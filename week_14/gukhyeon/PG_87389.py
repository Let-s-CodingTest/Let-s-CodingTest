def solution(n):
    answer = 0
    for i in range(1,n):
        if(n%i == 0):
            continue
        else:
            if(n%i == 1):
                return i
    return answer

print(solution(10))
print(solution(12))
print(solution(10))