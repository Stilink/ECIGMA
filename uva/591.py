from sys import stdin
def main():
    cases = 1
    n = int(stdin.readline())
    while n!=0:
        ar = [int(x) for x in stdin.readline().strip().split()]
        prom = sum(ar)/n
        ar.sort()
        suma=0
        for i in range(n):
            if(ar[i]>=prom):
                break
            suma+= abs(ar[i]-prom)
        print("Set #"+str(cases))
        print("The minimum number of moves is "+str(int(suma))+".")
        print()
        n = int(stdin.readline())
        cases += 1
        
        
main()
