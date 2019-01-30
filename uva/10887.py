from sys import stdin
def main():
    cases = int(stdin.readline())
    for case in range(cases):
        lf=set()
        leng1, leng2 = [int(x) for x in stdin.readline().strip().split()]
        l1=[]
        l2=[]
        for i in range(leng1):
            l1.append(stdin.readline().strip())
        for i in range(leng2):
            l2.append(stdin.readline().strip())
        for i in range(leng1):
            for j in range(leng2):
                lf.add(l1[i]+l2[j])
        print("Case "+str(case+1)+":",len(lf))
main()
        
    
