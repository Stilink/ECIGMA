from sys import stdin
ans = {}
def Ones(num):
    cnt=0
    while(num>0):
        cnt+=num&1
        num = num>>1
    return cnt


def solve(cadena):
    #print(bin(cadena))
    if(cadena in ans):
        return ans[cadena]
    control = Ones(cadena)
    """if(control <=1 ):
        ans["".join(cadena)]=control
        return control"""
    izquierda = 12
    derecha = 12
    for i in range(12):
        
        if (1<<i)&(cadena)==0:
            continue
        if( i+2<12):
            if((1<<(i+1))&(cadena))!=0 and ((1<<(i+2))&(cadena))==0:
                    #"""cadena[i-2]="o"
                    #cadena[i-1]="-"
                    #cadena[i]="-""""
                    temp = cadena
                    cadena = ((cadena|(1<<(i+2)))&(~(1<<(i+1))&(~(1<<i))))
                    if(cadena in ans):
                        izquierda = min(izquierda,ans[cadena])
                    else:
                        izquierda = min(solve(cadena),izquierda)
                        ans[cadena] = izquierda
                    cadena = temp
        if(i-1>0):
            if((1<<(i-1))&(cadena)==0 and ((1<<(i+1))&(cadena))!=0):
                    temp = cadena
                    #cadena[i]="-"
                    #cadena[i-1]="-"
                    #cadena[i+1]="o"
                    cadena = ((cadena|(1<<(i-1)))&(~(1<<i))&(~(1<<(i+1))))
                    if(cadena in ans):
                        derecha = min(derecha,ans[cadena])
                    else:
                        derecha = min(derecha,solve(cadena))
                        ans[cadena]= derecha
                    cadena = temp
    ans[cadena]=min(control,min(izquierda,derecha))
    return ans[cadena]
def main():
    cases = int(stdin.readline())
    for c in range(cases):
        linea = stdin.readline().strip()
        ans.clear()
        linea =(linea.replace("o","1"))
        linea= linea.replace("-","0")
        print(solve(int(linea,2)))
main()
