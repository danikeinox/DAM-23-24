def run_main():
    # Alerta! les llistes son mutables
    noms1 = ['Juan', 'Karla', 'Pedro']
    noms2 = 'Laura María Gonzalo Ernesto'.split()

    # Sumar llistes
    print(f'Sumar llistes {noms1 + noms2}')

    # Estendre una llista amb altra llista
    noms1.extend(noms2)
    print(f'Estendre la llista1: {noms1}')

    # Llista de nombres
    num1 = [10, 40, 15, 4, 20, 90, 4]
    print(f'Llista original: {num1}')

    # Obtenir l'índex del primer element trobat en una llista
    # help(list.index)
    print(f'Índex 4: {num1.index(4)}')

    # Invertir l'ordre dels elements d'una llista
    num1.reverse()
    print(f'Llista invertida: {num1}')

    # Ordenar els elements d'una llista
    num1.sort()
    print(f'Llista ordenada (ascendent): {num1}')
    # Ordenar de manera descendente un lista
    num1.sort(reverse=True)
    print(f'Llista ordenada (descendent): {num1}')

    # Obtenir el valor min y max d'una llista
    print(f'Valor mínim: {min(num1)}')
    print(f'Valor màxim: {max(num1)}')

    # Copiar els elements d'una llista
    num2 = num1.copy()
    # help(list.copy)
    print(f'Tenen la mateixa referència? {num1 is num2}')
    print(f'Tenen el mateix contingut? {num1 == num2}')

    # Podem utilitzar el constructor de la llista
    num2 = list(num1)
    print(f'Tenen la mateixa referència? {num1 is num2}')
    print(f'Tenen el mateix contingut? {num1 == num2}')

    # slicing
    num2 = num1[:]
    print(f'Tenen la mateixa referència? {num1 is num2}')
    print(f'Tenen el mateix contingut? {num1 == num2}')

    # Multiplicació de llistas
    llista_multiplicacio = 5 * [[2, 5]]
    print(llista_multiplicacio)
    print(f'Tenen la mateixa referència: {llista_multiplicacio[0] is llista_multiplicacio[1]}')
    print(f'Tenen el mateix contingut?: {llista_multiplicacio[0] == llista_multiplicacio[1]}')
    llista_multiplicacio[2].append(10)
    print(llista_multiplicacio)

    # Matrius en Python
    matriu = [[10, 20], [30, 40, 50], [60, 70, 80, 90]]
    print(f'Matriu original: {matriu}')
    print(f'Fila 0, Col·lumna 0: {matriu[0][0]}')
    print(f'Fila 2, Col·lumna 3: {matriu[2][3]}')
    matriu[2][0] = 65
    print(f'Matriu modificada: {matriu}')

    lista_listas = [[10, 14, 87, 90, 71], [4, 5, 6, 7], [9, 0, 11, 15, 45, 61, 70]]
    lista_listas.sort(key=len)
    print(f'Ordenar llista: {lista_listas}')

    # sorted built-in
    # help(sorted)
    noms1 = ['Juan Carlos', 'Karla', 'Pedro', 'Esperanza']
    noms1 = sorted(noms1)
    print(noms1)
    # ordenar de manera descendent
    noms1 = sorted(noms1, reverse=True)
    print(noms1)
    # Ordenar per la quantitat de caràcters (llarg)
    noms1 = sorted(noms1, key=len)
    print(noms1)
    # built-in reversed
    noms1 = reversed(noms1)
    print(list(noms1))


if __name__ == '__main__':
    run_main()
