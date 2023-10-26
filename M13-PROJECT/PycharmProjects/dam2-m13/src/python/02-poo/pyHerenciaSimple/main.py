from classes.Persona import Persona
from classes.Treballador import Treballador


def run_main():
    p = Persona('Rubén', 'Nadal', '12345678X')
    p.nom = 'Marc'
    print(f'Classe {p.__class__}: {p}')
    print(p)
    t = Treballador(p.nom, p.cognoms, '12345678X', 5_000)
    print(f'Classe {t.__class__}: {t}')


if __name__ == '__main__':
    run_main()
