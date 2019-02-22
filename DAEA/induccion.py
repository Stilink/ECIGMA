resultadoIterativo = 0
inicial = 1
segundo = 2
for i in range(1000):
    resultadoIterativo += inicial * segundo
    inicial += 1
    segundo +=1
resultadoConstante = (1000*((1000+1)*(1000+2)))//3
print(resultadoIterativo, resultadoConstante, resultadoConstante==resultadoIterativo)
