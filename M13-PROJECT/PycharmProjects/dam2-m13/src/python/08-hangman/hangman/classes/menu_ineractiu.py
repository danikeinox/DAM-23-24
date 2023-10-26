def logotype():
    with open("logotype.txt", "r", encoding="utf-8") as f:
        print(f.read())


class MenuInteractiu:

    @staticmethod
    def mostrar_menu():
        logotype()
        print("1. Jugar Hangman")
        print("2. Visualitzar Hall of Fame")
        print("3. Sortir")

    @staticmethod
    def veure_puntuacions():
        try:
            with open("hall_of_fame.txt", "r") as f:
                puntuacions = f.readlines()
                puntuacions = [line.strip() for line in puntuacions]

            puntuacions_ordenades = sorted(puntuacions, key=lambda x: int(x.split("amb")[1].split("fallos")[0].strip()),
                                           reverse=False)

            print("\nHall of Fame:")
            for puntuacio in puntuacions_ordenades:
                print(puntuacio)

        except FileNotFoundError:
            print("Encara no hi ha puntuacions.\n")
