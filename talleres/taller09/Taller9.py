class HashTable:
    def __init__(self):
        self.array = [None]*100
    

    def funcionHash(self, nombre):
        total = 0
        for i in nombre:
            total += ord(i)
        return total%len(self.array)


    def set(self, nombre, numero):
        self.array[self.funcionHash(nombre)] = numero

    def get(self, nombre):
        return self.array[self.funcionHash(nombre)]


