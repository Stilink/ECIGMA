from sys import stdin
def main():
    cases = int(stdin.readline())
    for case in range(cases):
        n = int(stdin.readline())
        suma=0
        for i in range(n):
            a,b,c=[int(x) for x in stdin.readline().strip().split()]
            suma+= (a*c)
        print(suma)
main()
