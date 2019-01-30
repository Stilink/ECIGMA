from sys import stdin
def main():
    n = int(stdin.readline())
    while(n!=0):
        distancias=[]
        dist=float("inf")
        for i in range(n):
            linea = stdin.readline()
            dist=min(dist,linea.count(" "))
            distancias.append(linea.count(" "))
        suma=0
        for i in distancias:
            suma+= (i-dist)
        print(suma)
        n = int(stdin.readline())
main()
            
