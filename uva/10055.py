from sys import stdin
def main():
    linea= stdin.readline().strip().split()
    while linea:
        print(abs(int(linea[1-1])-int(linea[2-1])))
        linea = stdin.readline().strip().split()
main()
