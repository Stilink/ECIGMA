from sys import stdin
def main():
    linea = stdin.readline().strip().split()
    while linea:
        i=0
        for j in range(len(linea[1])):
            if(i>=len(linea[0])):
                break
            if(linea[1][j]==linea[0][i]):
                i+=1
        if(i==len(linea[0])):
            print("Yes")
        else:
            print("No")
        linea = stdin.readline().strip().split()

main()
