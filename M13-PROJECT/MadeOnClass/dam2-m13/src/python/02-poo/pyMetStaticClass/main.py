from classes.estudiant import Estudiant


def run_main():
    # Tot correcte ;-)
    e = Estudiant.from_nom_complet('Rubén Nadal Bellver', 1975)
    print(f"{e} \nÈs instància d'Estudiant? {isinstance(e, Estudiant)}")

    # ALERTA: Amb el mètode estàtic e1 no és instància de la classe Estudiant !!!!
    e1 = Estudiant.from_edat_pare('Rubén', 'Nadal Bellver', 1947, 28)
    print(f"{e1} \nÈs instància d'Estudiant? {isinstance(e1, Estudiant)}")


if __name__ == '__main__':
    run_main()
