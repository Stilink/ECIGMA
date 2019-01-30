from sys import stdin
def main():
    lineaB = stdin.readline().strip()
    linea = stdin.readline().strip()
    while(linea[0]!="_"):
        cad=""
        for i in range(len(linea)):
            if(linea[i]==" "):
                cad+="0"
            elif(linea[i]=="o"):
                cad+="1"
            else:
                continue
        print(chr(int(cad,2)),end="")
        linea = stdin.readline().strip()
main()
        
