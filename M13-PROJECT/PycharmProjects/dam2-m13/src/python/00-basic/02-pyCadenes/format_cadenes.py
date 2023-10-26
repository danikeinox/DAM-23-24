def concatenar():
    print(f'Exemples de concatenació de str')
    variable = 'Adéu'
    missatge = 'Hola' 'Món! ' + variable
    missatge += 'Ins Eugeni d\'Ors' 'Python'
    print(missatge)

    tupla_str = ('Hola', 'Món', 'Ins', 'Eugeni d\'Ors')
    missatge = ' '.join(tupla_str)
    print(f'missatge: {missatge}')

    llista = ['Java', 'Python', 'Django', 'mariaDB']
    missatge = ', '.join(llista)
    print(f'missatge: {missatge}')

    cadena = 'HolaMón'
    missatge = '.'.join(cadena)
    print(f'missatge: {missatge}')

    diccionari = {'nom': 'Pep', 'cognom': 'Carabassa', 'edat': '25'}
    claus = ' '.join(diccionari.keys())
    valors = ' '.join(diccionari.values())
    print(f'claus: {claus}, type: {type(claus)}')
    print(f'valors: {valors}, type: {type(valors)}')


def cadenes_inmutables():
    print(f'Immutabilitat del tipus de dades str')
    missatge1 = 'hola món'
    missatge2 = missatge1.capitalize()
    print(f'missatge1: {missatge1}, id: {hex(id(missatge1))}')
    print(f'missatge2: {missatge2}, id: {hex(id(missatge2))}')
    missatge1 += 'adéu'
    print(f'missatge1: {missatge1}, id: {hex(id(missatge1))}')
    # Reviseu les adreces de memòria i comprovareu que cada cadena té una adreça diferent


def splitejar_cadenes():
    print(f'Convertir un string en list --> split')
    cursos = 'Java Python Django mariaDB influxdb C'
    llista = cursos.split()
    print(f'Llista cursos 1: {llista}')
    print(type(llista))

    cursos_separats_per_coma = 'Java, Python, Django, mariaDB, influxdb, C'
    llista = cursos_separats_per_coma.split(', ')
    print(f'Llista cursos 2: {llista}')
    print(type(llista))

    llista = cursos_separats_per_coma.split(', ', 3)  # màxim splits
    print(f'Llista cursos 3: {llista}')
    print(type(llista))


# Diferents maneres de donar format a un str
def format_cadenes():
    nom = 'Juan'
    edat = 28
    sou = 3000
    missatge = 'Nom {} Edat {} Sou {:.2f}'.format(nom, edat, sou)
    print(missatge)

    missatge = 'Nom {0} Edat {1} Souu {2:.2f}'.format(nom, edat, sou)
    print(missatge)

    missatge = 'Sou {2:.2f} Edat {1} Nom {0}'.format(nom, edat, sou)
    print(missatge)

    missatge = 'El meu nom és %s i tinc %d anys' % (nom, edat)
    print(missatge)

    persona = ('Karla', 'Gomez', 5000.00)
    missatge = 'Hola %s %s. El teu sou és %.2f' % persona
    print(missatge)

    missatge = 'Hola %s %s. Tu sueldo es %.2f'
    print(missatge % persona)

    diccionari = {'nom': 'Ivan', 'edat': 35, 'sou': 8000.00}
    missatge = 'Nom {dic[nom]} Edat {dic[edat]} Sou {dic[sou]:.2f}'.format(dic=diccionari)
    print(missatge)


# Format de cadenes com f-string
def format_cadena_fstring():
    print(f'Format de cadenes amb f-string')
    nom = 'Juan'
    edat = 28
    sou = 3000
    missatge = f'Nom: {nom} Edat: {edat} Sou: {sou:.2f}'
    print(missatge)

    # Mètode print
    print(nom, edat, sou, sep=', ')


def run_main():
    concatenar()
    cadenes_inmutables()
    splitejar_cadenes()
    format_cadenes()
    format_cadena_fstring()


if __name__ == '__main__':
    run_main()
