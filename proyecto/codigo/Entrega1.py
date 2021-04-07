import os
import sys
import numpy as np
import pandas as pd

def read(arch):
    file = os.listdir(arch) #lista de los archivos
    for i in range(len(file)):
        dirc = arch +"/"+ file[i]
        data = pd.read_csv(dirc,header=None) #Lectura del arch
        dArr = np.asarray(data) #Transformado en matriz de datos
        print(dArr)
