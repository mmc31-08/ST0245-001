import pandas as pd

def archCsv(file):
    data = pd.read_csv(file, header=0)
    print(data.shape)
    print(data.head(10))




