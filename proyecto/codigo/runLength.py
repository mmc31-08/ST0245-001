from PIL import Image
import numpy as np
import csv
import cv2
import tracemalloc
import time 
import os 

def compression(st):
    data = []
    
    for j in range(len(st)):
        row = st[j]
        output = []
        n = len(row)
        i = 0
        while i < n:
            count = 1
            tmp = row[i]
            while (i < n - 1 and row[i] == row[i + 1]):
                count += 1
                i += 1
            i += 1

            if count>1:
                output.append('#'+str(count))
            output.append(str(tmp))
        data.append(output)

    return data



def decompression(st):
        data = []
        
        for j in range(len(st)):
            row = st[j]
            output = []
            n= len(row)
            i = 0
            
            while i < n:
                tmp = row[i]
                if tmp[0] == '#':
                    var = int(float(row[i+1]))
                    tmp = int(tmp[1:])
                    for j in range(tmp):
                        output.append(var)
                    i += 1
                else:
                    output.append(int(float(tmp)))
                i += 1
            
            data.append(output)
        
        return data

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
        comp.append((f, time.time() - n, peak / 10**6, os.path.getsize(f)/ 10**6))  # agrego resultados a lista comp
        tracemalloc.stop()  # detengo contador de memoria
        tracemalloc.start()  # inicio contador de memoria
        n = time.time() # inicio contador de tiempo
        newImage = decompression(image)  # inicio algoritmo de descompresion
        current, peak = tracemalloc.get_traced_memory()  # inicio contador de memoria
        deco.append((f, time.time() - n, peak / 10**6, os.path.getsize(f)/ 10**6)) # agrego resultados a lista deco
        cv2.imwrite(os.path.join(output_dir, path) , np.array(newImage))  # guarda imagen resultante
        tracemalloc.stop() #Deteng el contador de memoria 

    with open("compression_benchmarks_RunLength.csv", "w") as f:  # copiar resultados a archivo csv
        writer = csv.writer(f)
        writer.writerow(["path", "time", "memory", "filesize"])
        for line in comp:
            writer.writerow(line)
    with open("decompression_benchmarks_RunLength.csv", "w") as f: # copiar resultados a archivo csv
        writer = csv.writer(f)
        writer.writerow(["path", "time", "memory", "filesize"])
        for line in deco:
            writer.writerow(line)



ruta = r"C:\Users\DELL\Desktop\Datos y Algoritmos\Proyecto\codigo\pythonProject\test"
output = r"C:\Users\DELL\Desktop\Datos y Algoritmos\Proyecto\codigo\pythonProject\RunLengthOutput"

# runBenchmarks(ruta, compression, decompression, output)



