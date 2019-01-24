from sys import stdin
def main():
    n = int(stdin.readline())
    for case in range(n):
        number = int(stdin.readline())
        res = int(((((((number*567)/9)+7492)*235)/47)-498))
        print(str(res)[-2])
main()
