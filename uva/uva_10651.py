from sys import stdin
ans = {}
def solve(cadena):
    if("".join(cadena) in ans):
        return ans[cadena]
    control = cadena.count("o")
    if(control <=1 ):
        ans["".join(cadena)]=control
        return control
    izquierda = len(cadena)
    derecha = len(cadena)
    for i in range(12):
        if cadena[i]=='-':continue
        if( i-2>=0):
            if(cadena[i-1]=="o" and cadena[i-2]=="-"):
                    temp = cadena.copy()
                    cadena[i-2]="o"
                    cadena[i-1]="-"
                    cadena[i]="-"
                    Sizquierda = "".join(cadena)
                    if(Sizquierda in ans):
                        izquierda = min(izquierda,ans[Sizquierda])
                    else:
                        izquierda = min(solve(cadena),izquierda)
                        ans[Sizquierda] = izquierda
                    cadena = temp.copy()
        if(i+2<len(cadena)):
            if(cadena[i+1]=="-" and cadena[i-1]=="o"):
                    temp = cadena.copy()
                    cadena[i]="-"
                    cadena[i-1]="-"
                    cadena[i+1]="o"
                    Sderecha = "".join(cadena)
                    if(Sderecha in ans):
                        derecha = min(derecha,ans[Sderecha])
                    else:
                        derecha = min(derecha,solve(cadena))
                        ans[Sderecha]= derecha
                    cadena = temp.copy()
    ans["".join(cadena)]=min(izquierda,derecha)
    return ans["".join(cadena)]
def main():
    cases = int(stdin.readline())
    for c in range(cases):
        linea = stdin.readline().strip()
        ans.clear()
        print(solve(list(linea)))
main()
