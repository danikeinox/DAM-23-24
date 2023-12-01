from conceptes.cap import Cap
from conceptes.seccio import Seccio
from conceptes.treballador import Treballador


def run_main():
    treballadors = [Cap(nom="Lluís el cap", sou=30000.0, seccio=Seccio.ADMINISTRACIO, alta_contracte="15/11/2011", incentiu=555.0),
                    Treballador(nom="Luis", sou=20000.0, seccio=Seccio.ADMINISTRACIO, alta_contracte="15/11/2011"),
                    Treballador(nom="Ana", sou=25000.0, seccio=Seccio.ADMINISTRACIO, alta_contracte="21/07/2007"),
                    Treballador(nom="Marta", sou=27000.0, seccio=Seccio.ADMINISTRACIO, alta_contracte="21/07/2007")
                    ]

    # Ordenat de menor a major sou
    # treballadors.sort(key=lambda t: t.sou)
    # Ordenat de major a menor sou
    treballadors.sort(key=lambda t: t.sou, reverse=True)
    for t in treballadors:
        print(f'{t}\n')


if __name__ == '__main__':
    run_main()
