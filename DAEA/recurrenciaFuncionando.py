r=[6,18]
def rec(n):
    n-=1
    return r.append(5*r[n-1]-(6*r[n-2]))

for i in range(3,10000):
    rec(i)
ansRec = set(r)
ansCons=set()
for i in range(1,10000):
    ansCons.add((2)*(3**i))
print(ansRec-ansCons)


