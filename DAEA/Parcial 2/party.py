from sys import stdin
def solve(c, i):
    global l
    global v
    global b
    global ps
#    print("c:",c,"i:",i)
    if(i>=ps):
        print("i demasiado grande")
        return -1
    if(c>b):
        return -1
    if(c==b):
        return c
    temp = 0
    temp2 =0
    if(not v[i]):
        v[i]= True
        temp =solve(c+l[i][0],i+1)
        v[i]=False
        print(temp)
    else:
        temp2 = solve(c,i+1)
        print(temp)
    print(temp, temp2)
    c=max(temp,temp2)
    return c
                   
    
def main():
    global l
    global v
    global b
    global ps
    b, ps = [int(x) for x in stdin.readline().strip().split()]
    while(b!=0 and ps!=0):
        l=[]
        v=[False]*ps
        for pary in range(ps):
            p, f =[int(x) for x in stdin.readline().strip().split()]
            l.append([p, f])
        print(solve(0, 0))
        stdin.readline()
        b, ps = [int(x) for x in stdin.readline().strip().split()]
main()
