def run_main():
    # * desempaquetar
    numeros = [1, 2, 3]
    print(numeros)
    print(*numeros)
    print(*numeros, sep=' - ')

    # Desempaquetant al moment de passar un paràmetre una funció
    def sumar(x, y, z):
        print(f'Resultat suma: {x + y + z}')

    sumar(*numeros)

    # Extreure algunes parts d'una llista
    mi_lista = [1, 2, 3, 4, 5, 6]
    x, *y, z, t = mi_lista
    print(x, y, z, t)

    # Unir llista
    llista1 = [1,2,3]
    llista2 = [4,5,6]
    llista3 = [llista1, llista2]
    print(f'Llista de llistes: {llista3}')

    llista3 = [*llista1, *llista2]
    print(f'Unir llistes: {llista3}')

    # Unir diccionaris
    dic1 = {'A': 1, 'B': 2, 'C': 3}
    dic2 = {'D': 4, 'E': 5}
    dic3 = {**dic1, **dic2}
    print(f'Unir diccionaris: {dic3}')

    # Construir una llista a partir d'un str
    llista = [*'HolaMon']
    print(llista)
    print(*llista, sep='')


if __name__ == '__main__':
    run_main()