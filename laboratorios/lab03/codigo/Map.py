class Node:
    def __init__(self, id, x, y, name=None):
        self.id = int (id)
        self.x = float(x)
        self.y = float(y)
        self.loc = name


def main():
    mapMedellin = []
    with open("medellin_colombia-grande.txt", "r") as file:
        i = 0
        while f:=file.readline():
            i+=1
            if i==0:
                continue

            arr = f.split()
            nums = arr[0:3]
            loc = arr[3:]

            if not nums:
                break
            mapMedellin.append(Node(*nums, loc))
            
    return mapMedellin

