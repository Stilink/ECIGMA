from sys import stdin
def main():
    dic = {}
    cases = int(stdin.readline())
    for case in range(cases):
        linea= stdin.readline().strip().split()
        if(linea[0] in dic):
            dic[linea[0]]+=1
        else:
            dic[linea[0]]=1
    keys=list(dic.keys())
    keys.sort()
    for key in keys:
        print(key,dic[key])
main()
            
