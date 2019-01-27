from sys import stdin
def main():
    n,m = [int(x) for x in stdin.readline().strip().split()]
    last="%"
    end=False
    for i in range(n):
        linea=stdin.readline().strip()
        if(len(linea.replace(linea[0],""))!=0):
            end=True
            break
        elif(linea[0]==last):
            end=True
            break
        else:
            last=linea[0]
            end=False
    if(not end):
        print("YES")
    else:
        print("NO")
main()
        
       
