from sys import stdin
dic = {"A":2,"B":2,"C":2,"D":3,"E":3,"F":3,"G":4,"H":4,"I":4,"J":5,"K":5,"L":5,"M":6,"N":6,"O":6,"P":7,"R":7,"S":7,"T":8,"U":8,"V":8,"W":9,"X":9,"Y":9,"2":2,"3":3,"4":4,"5":5,"6":6,"7":7,"8":8,"9":9,"1":1,"0":0}

def main():
    cases = int(stdin.readline())
    for case in range(cases):
        solc={}
        lineabasurajajasalu2=stdin.readline().strip()
        n= int(stdin.readline())
        for j in range(n):
            cadena = ""
            linea=stdin.readline().strip()
            for i in range(len(linea)):
                if(linea[i] in dic):
                    cadena+=str(dic[linea[i]])
            if(cadena in solc):
                solc[cadena]+=1
            else:
                solc[cadena]=1

        keys= list(solc.keys())
        keys.sort()
        printie=False
        for i in keys:
            if(solc[i]>1):
                printie=True
                print(i[:3]+"-"+i[3:]+" "+str(solc[i]))
        if(not printie):
            print("No duplicates.")
        if(case!=cases-1):
            print()
        
        
main()

    
    
    
