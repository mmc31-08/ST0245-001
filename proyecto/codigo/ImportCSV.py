import csv


def readCSV(file):
    with open(file, mode='r') as File:
        reader = csv.reader(File)
        for row in reader:
            print(row)




def writeCSV(filename, info):
    with open(filename, mode='w') as File:
        writer = csv.writer(File, delimiter=",")
        for row in  csv.writer(info):
            writer.writerow([x for x in range(10)])
            print(row)