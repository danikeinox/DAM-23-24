from ResourceManager import ResourceManager


def crea_arxiu(nom_arxiu):
    with ResourceManager(nom_arxiu, 'w') as rm:
        rm.write('01 - Hola món des d\'un fitxer\n')  # Escriu línia a línia (alerta amb el \n)
        rm.write('02 - Hola món des d\'un fitxer\n')
        rm.write('03 - Hola món des d\'un fitxer\n')
        llista = ('04 - També podem\n', '05 - escriure\n', '06 - amb un iterador\n')
        rm.writelines(llista)  # Escriu el contingut d'un iterador (alerta amb el \n)


def llig_arxiu(nom_arxiu):
    tmp = None
    with ResourceManager(nom_arxiu, 'r') as rm:
        #  Fes proves comentant i descomentant, línia a línia
        tmp = rm.read()  # Llig completament el fitxer
        #  tmp = rm.read(13)  # Llegim 13 caràcters
        #  for linia in rm.readlines():  # readlines() retorna un iterador que podem recòrrer
        #      print(linia)
    return tmp


def copia_arxiu(nom_arxiu_origen, nom_arxiu_destinacio):
    with ResourceManager(nom_arxiu_origen, 'r') as origen:
        with ResourceManager(nom_arxiu_destinacio, 'a') as detinacio:
            detinacio.write(origen.read())


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
