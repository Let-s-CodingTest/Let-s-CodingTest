'''
N일 때 가능한 경우
1.길이가 N-1인 경우에다가 뒤에 1을 붙이기
2. 길이가 N-2인 경우에다가 뒤에 00 붙이기
'''
n=int(input())
dp=[0]*1000001
dp[1]=1
dp[2]=2

for i in range(3, n+1) :
    dp[i]=(dp[i-2]+dp[i-1])%15746
print(dp[n])