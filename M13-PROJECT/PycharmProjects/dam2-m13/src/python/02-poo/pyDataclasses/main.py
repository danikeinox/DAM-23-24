from model.persona import Persona, Domicili


def run_main():
    d1 = Domicili('C/ Detonador, n 47', '08720', 'Vilafranca del Penedès')
    p1 = Persona(1, 'Alex', 'Plosivo', d1, '01/01/2021 13:30:00', 'aplosivo', '124')
    print(f'Original --> {p1}')
    #p1.nom = 'Herman' # frozen = False, si ho canvies a True sera inmutable
    print(f'Modificat --> {p1}')

    # Comprovem la igualtat
    d2 = Domicili('C/ Detonador, n 47', '08720', 'Vilafranca del Penedès')
    p2 = Persona(1, 'Alex', 'Plosivo', d2, '01/01/2021 13:30:00', 'aplosivo', '124')
    print(f'Són iguals p i p2? {p1 == p2}')

    # Podem crear una llista inmutable? --> Alerta amb frozen
    # tupla = (p1, p2)
    # print(tupla)

    # Podem crear una llista mutable? --> Alerta amb frozen
    llista = {p1, p2}
    print(llista)
    # llista[0].nom = 'Felip' # Donarà error ja que es inmutable frozen = True


if __name__ == '__main__':
    run_main()
