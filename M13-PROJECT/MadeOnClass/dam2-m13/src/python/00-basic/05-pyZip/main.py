def exemples_zip():
    # Mostra les funcions incorporades a python
    # print(dir(__builtins__))
    # Mostra l'ajuda de la funció zip
    # help(zip)
    print(f'Exemples amb zip')
    numeros = (1, 2, 3)
    lletres = ['a', 'b', 'c']
    barreja = zip(numeros, lletres)
    print(barreja)
    print(list(barreja))
    print(tuple(zip(numeros, lletres)))

    # Sempre agafa el nombre menor. En aquest cas 3
    numeros = (1, 2, 3)
    lletres = ['a', 'b', 'c', 'd', 'e']
    identificadors = 11, 33, 55, 77, 99
    conjunt = {22, 44, 66, 88, 100, 120, 140}
    barreja = zip(numeros, lletres, identificadors, conjunt)
    print(barreja)
    print(list(barreja))
    print(tuple(zip(numeros, lletres, identificadors, conjunt)))  # conjunt --> valors aleatoris

    # Iteració dels zip en paral·lel
    for numero, lletra, identificador, aleatori in zip(numeros, lletres, identificadors, conjunt):
        print(f'Número: {numero} LLetra: {lletra} Indentificador: {identificador} Aleatori: {aleatori}')

    llista = []
    for numero, lletra, identificador, aleatori in zip(numeros, lletres, identificadors, conjunt):
        llista.append(f'{identificador}-{numero}_{lletra}#{aleatori}')

    print(llista)


# Com desempaquetar un zip
def exemples_unzip():
    # Desempaquetar un zip
    print(f'\nExemples de desempaquetat d\'un zip')
    barreja = [(1, 'a'), (2, 'b'), (3, 'c')]
    numeros, lletres = zip(*barreja)
    print(f'Números: {numeros}, Lletres: {lletres}')


def ordenar_zip():
    print(f'\nExemples d\'ordenació amb zip')
    lletres = ['c', 'd', 'a', 'e', 'b']
    numeros = [3, 2, 4, 1, 0]
    barreja = zip(lletres, numeros)
    # Cap ordre
    print(tuple(barreja))
    # ordenar per lletra (primer iterable)
    print(sorted(zip(lletres, numeros)))


def crear_diccionari_amb_zip():
    # Crear un diccionari amb zip i dos iterables
    print(f'\nExemples de creació d\'un diccionari amb zip')
    claus = ['Nom', 'Cognoms', 'Edat']
    valors = ['Joan', 'Molina', 18]
    diccionari = dict(zip(claus, valors))
    print(diccionari)

    # Actualitzar un element d'un diccionari
    clau = ['Edad']
    nova_edat = [28]
    diccionari.update(zip(clau, nova_edat))
    print(diccionari)


def run_main():
    exemples_zip()
    exemples_unzip()
    ordenar_zip()
    crear_diccionari_amb_zip()


if __name__ == '__main__':
    run_main()
