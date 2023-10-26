"""
    arxiu = open('ruta_al_fitxer', 'mode_obertura', 'codificació')

    La codificació especifica el joc de caràcters del fitxer. utf8 és la recomanada

    Modes d'obertura:
        'r': solament lectura
        'w': solament escriptura
        'a': afegeix al final del fitxer

        D'altra banda, en qualsevol d'aquestes maneres es pot agregar un + per a passar a una manera lectura-escriptura.
        El comportament de r+ i de w+ no és el mateix, ja que en el primer cas es té l'arxiu complet, i en el segon cas
        es trunca l'arxiu, perdent així les dades.
    Nota
        Si un arxiu no existeix i li ho intenta obrir en manera lectura, es generarà un error; en canvi si li ho obre
        per a escriptura. Python s'encarregarà de crear l'arxiu al moment d'obrir-lo, ja sigui amb w, a, w+ o amb a+).
    Advertencia:
        Si un arxiu existent s'obre en manera escriptura (w o w+), totes les dades anteriors són esborrades i
        reemplaçades pel que s'escrigui en ell.
"""

#  Joc de caràcters per als fitxers de text
CODIFICACIO = 'utf8'


def crea_arxiu(nom_arxiu):
    try:
        arxiu = open(nom_arxiu, 'w', encoding=CODIFICACIO)
        arxiu.write('01 - Hola món des d\'un fitxer\n')  # Escriu línia a línia (alerta amb el \n)
        arxiu.write('02 - Hola món des d\'un fitxer\n')
        arxiu.write('03 - Hola món des d\'un fitxer\n')
        llista = ('04 - També podem\n', '05 - escriure\n', '06 - amb un iterador\n')
        arxiu.writelines(llista)  # Escriu el contingut d'un iterador (alerta amb el \n)
    except Exception as e:
        print(e)
    finally:
        arxiu.close()  # És recomanable tancar l'arxiu


def llig_arxiu(nom_arxiu):
    tmp = None
    try:
        arxiu = open(nom_arxiu, 'r', encoding=CODIFICACIO)
        #  Fes proves comentant i descomentant, línia a línia
        tmp = arxiu.read()  # Llig completament el fitxer
        #  tmp = arxiu.read(13)  # Llegim 13 caràcters
        #  for linia in arxiu.readlines():  # readlines() retorna un iterador que podem recòrrer
        #      print(linia)
    except Exception as e:
        print(e)
    finally:
        arxiu.close()  # És recomanable tancar l'arxiu
    return tmp


def copia_arxiu(nom_arxiu_origen, nom_arxiu_destinacio):
    try:
        origen = open(nom_arxiu_origen, 'r', encoding=CODIFICACIO)
        desti = open(nom_arxiu_destinacio, 'a', encoding=CODIFICACIO)
        desti.write(origen.read())  # Escrivim el contingut del fitxer
    except Exception as e:
        print(e)
    finally:
        origen.close()
        desti.close()


def run_main():
    origen = 'fitxer.txt'
    desti = 'copia_fitxer.txt'
    print(f'Creació de l\'arxiu {origen}'.center(50, '-'))
    crea_arxiu(origen)
    print(f'Lectura de l\'arxiu {origen}'.center(50, '-'))
    print(llig_arxiu(origen))
    print(f'Procés de copia d\'arxius'.center(50, '-'))
    copia_arxiu(origen, desti)
    print(f'Lectura de l\'arxiu copiat {desti}'.center(50, '-'))
    print(llig_arxiu(desti))
    print(f'Procés completat'.center(50, '-'))


if __name__ == '__main__':
    run_main()
