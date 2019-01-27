from sys import stdin
def main():
    dic={}
    linea = stdin.readline().strip().split()
    while(linea):
        dic[linea[1]]=linea[0]
        linea= stdin.readline().strip().split()
    linea= stdin.readline().strip()
    while(linea):
        if(linea not in dic):
            print("eh")
        else:
            print(dic[linea])
        linea= stdin.readline().strip()
main()
