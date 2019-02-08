from sys import stdin
def main():
    n = stdin.readline().strip()
    while n:
        n = int(n)
        cnt = 0
        while(n!=0):
            """print(n, cnt)"""
            if(n%2 == 0):
                n=n//2
            else:
                if((n//2)==1 or ((n//2)%2==0)):
                    n-=1
                elif((n//2)%2!=0):
                    n+=1
                
            cnt+=1
        print(cnt)
        n = stdin.readline().strip()
main()
