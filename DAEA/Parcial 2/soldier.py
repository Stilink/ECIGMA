from sys import stdin
from heapq import heappush
from heapq import heappop

types = {1:[] , 2:[] , 3:[] , 4:[] , 5:[] , 6:[] }

def main():
    try:
        n, t = [int(x) for x in stdin.readline().strip().split()]
        for cn in range(n):
            typ, p, q = [int(x) for x in stdin.readline().strip().split()]
            if(typ not in types):
                continue
            if(len(types[typ])>=1):
                listaARevisar = heappop(types[typ])
                if(listaARevisar[0]<q and listaARevisar[1]<t):
                    heappush(types[typ], [q,p])
                else:
                    heappush(types[typ], listaARevisar)
            else:
                heappush(types[typ], [q,p])
        mini = (2**30)
        can = True
        for i in range(1,7):
            if(len(types[i])>0):
                mini = min(mini, heappop(types[i])[0])
            else:
                can = False
        if(mini==(2**30)):
            print("0")
        elif(can):
            print(mini)
        else:
            print("0")
    except:
        print("0")
    
main()
