from sys import stdin
def main():
    linea = stdin.readline().strip().split()
    while(linea):
        print((int(linea[0])*int(linea[1]))-1)
        linea = stdin.readline().strip().split()
main()
        
         
