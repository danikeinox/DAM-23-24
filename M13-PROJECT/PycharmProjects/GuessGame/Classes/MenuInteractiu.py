class MenuInteractiu:
    @staticmethod
    def mostrar_menu():
        print("1. Jugar")
        print("2. Veure puntuacions (hall of fame)")
        print("3. Sortir")

    @staticmethod
    def veure_puntuacions():
        try:
            with open("hall_of_fame.txt", "r") as f:
                puntuacions = f.readlines()
                puntuacions = [line.strip() for line in puntuacions]

            puntuacions_ordenades = sorted(puntuacions, key=lambda x: int(x.split(":")[1]), reverse=False)

            print("\nHall of Fame:")
            for puntuacio in puntuacions_ordenades:
                print(puntuacio)

        except FileNotFoundError:
            print("Encara no hi ha puntuacions.")
