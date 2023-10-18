from classes import GestorEsdeveniments

def logotype():
    with open("logotype.txt", "r", encoding="utf-8") as f:
        print(f.read())


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    logotype()
    GestorEsdeveniments.mostrar_esdeveniments()
