from sys import stdin
def rec(s, t, string):
    if(s not in string):
        return string
    else:
        string= string.replace(s,t,1)
        return rec(s,t,string)
    
def main():
    nr = int(stdin.readline())
    while nr!=0:
        rules=[]
        for i in range(nr):
            rules.append([stdin.readline().strip(),stdin.readline().strip()])
        string = stdin.readline().strip()
        for i in range(nr):
            string = rec(rules[i][0],rules[i][1], string)
        print(string)
        nr=int(stdin.readline())
main()
