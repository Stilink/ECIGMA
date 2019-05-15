from sys import stdin
dp={}
def solve(i, c):
    global maxi, linea, dp
    if c in dp:
        return dp[c]
    if(i>=len(linea)):
        if(c>maxi):
            return -1
        else:
            return c
    if(c>maxi):
        return -1
    elif(c==maxi):
        return c
    else:
        dp[c+linea[i]] = solve(i+2, c+linea[i])
        dp[c] = solve(i+1, c)
        dp[c] = max(dp[c+linea[i]],dp[c])
        return dp[c]
def main():
    global maxi, linea, dp
    cases = int(stdin.readline())
    for cas in range(1,cases+1):
        dp={}
        n, maxi = [int(x) for x in stdin.readline().strip().split()]
        values = []
        linea = [int(x) for x in stdin.readline().strip().split()]
        print("Scenario #"+str(cas)+":", solve(0, 0))
main()
        
            
