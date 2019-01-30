from sys import stdin
from math import ceil
def main():
    n,m,k= [int(x) for x in stdin.readline().strip().split()]
    print(ceil(n/k)*ceil(m/k))
main()
    
