from PIL import Image
import numpy as np
from collections import deque
import tracemalloc
import time 
import os 
import csv
import cv2

def imageScallingCompression(im):

    factor = 2
    x = im.shape[0]//factor
    y = im.shape[1]//factor
    output = []

    for i in range(x):
        row = []
        for j in range(y):
            row.append(im[i*factor][j*factor])
        output.append(row)
    
    return output


def imageScallingDecompression(im):
    factor = 2
    m = im.shape[0]
    n = im.shape[1]
    mp = m*factor
    np = n*factor

    output = [[0 for _ in range(np)]for _ in range(mp)] 

    for i in range(m):
        for j in range(n):
            output[i*factor][j*factor] = im[i][j]
            queue = deque()
            queue.append((i*factor, j*factor))
            iter = factor//2
            visited = set()
            visited.add((i*factor, j*factor))
            while queue and iter:
                temp = deque()
                while queue:
                    a,b = queue.popleft()
                    for x,y in ((0,1),(0,-1),(1,0),(-1,0),(1,1),(1,-1),(-1,1),(-1,-1)):
                        if 0<=a+x<m*factor and 0<=b+y<n*factor and not(a+x, b+y) in visited: 
                            temp.append((a+x, b+y))
                            visited.add((a+x, b+y))
                            output[a+x][b+y] = output[i*factor][j*factor]
                iter-=1
    return output




def runBenchmarks(directory, compression, decompression, output_dir):

    comp = []
    deco = []

    for path in os.listdir(directory):

        f = os.path.join(directory, path)  # saco ruta de cada imagen
        tracemalloc.start()  # inicio contador de memoria
        n = time.time() # inicio contador de tiempo 
        im = np.array(Image.open(f).convert("L")) #Cargo la imagen a un arreglo de numpy
        image = compression(im) # realizo algoritmo compresion
        current, peak = tracemalloc.get_traced_memory()  # tomo datos de memoria
        comp.append((f, time.time() - n, peak / 10**6, os.path.getsize(f)  / 10 ** 6))  # agrego resultados a lista comp
        tracemalloc.stop()  # detengo contador de memoria
        tracemalloc.start()  # inicio contador de memoria
        n = time.time() # inicio contador de tiempo
        newImage = decompression(np.array(image))  # inicio algoritmo de descompresion
        current, peak = tracemalloc.get_traced_memory()  # inicio contador de memoria
        deco.append((f, time.time() - n, peak / 10**6, os.path.getsize(f)/ 10 ** 6)) # agrego resultados a lista deco
        cv2.imwrite(os.path.join(output_dir, path) , np.array(newImage))  # guarda imagen resultante
        tracemalloc.stop() #Deteng el contador de memoria 

    with open("compression_benchmarks_ImS.csv", "w") as f:  # copiar resultados a archivo csv
        writer = csv.writer(f)
        writer.writerow(["path", "time", "memory", "filesize"])
        for line in comp:
            writer.writerow(line)
    with open("decompression_benchmarks_ImS.csv", "w") as f: # copiar resultados a archivo csv
        writer = csv.writer(f)
        writer.writerow(["path", "time", "memory", "filesize"])
        for line in deco:
            writer.writerow(line)


ruta = r"C:\Users\DELL\Desktop\Datos y Algoritmos\Proyecto\codigo\pythonProject\test"
output = r"C:\Users\DELL\Desktop\Datos y Algoritmos\Proyecto\codigo\pythonProject\ImageScallingOutput"

# runBenchmarks(ruta, imageScallingCompression, imageScallingDecompression, output)

