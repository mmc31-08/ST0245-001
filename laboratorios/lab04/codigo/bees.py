import math
from collections import defaultdict

class Punto:
    def __init__(self, x, y, z):
        self.x = x
        self.y = y
        self.z = z

def distance(p1, p2):
    distancia = math.sqrt((p2[0]-p1[0])**2)+((p2[1]-p1[1])**2) +((p2[2]-p1[2])**2)
    return distancia


bees = []
distancia = defaultdict(list)


with open("cordenadas100abejas.text", "r") as file:
    while line:=file.readline():
        bees.append(tuple(map(float, line.split(","))))


for p1 in bees:
    for p2 in bees:
        dis = distance(p1,p2)
        if dis<=100 and p1!=p2:
            distancia[p1].append(p2)

print(distancia)


