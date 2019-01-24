from sys import stdin
def main():
    linea = stdin.readline().strip().split()
    while linea:
        velocidad = int(linea[0])
        tiempo = int(linea[1])
        print(velocidad*tiempo*2)
        linea = stdin.readline().strip().split()
main()
