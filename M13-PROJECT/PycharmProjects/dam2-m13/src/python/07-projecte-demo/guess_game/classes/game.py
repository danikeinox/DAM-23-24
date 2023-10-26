import random
from datetime import date

from guess_game.classes.jugador import Jugador

_MIN = 1
_MAX = 100


class Game:
    def __init__(self):
        self.nombre_aleatori = 0
        self.jugador = None

    def generar_nombre_aleatori(self):
        self.nombre_aleatori = random.randint(_MIN, _MAX)

    def jugar(self):
        self.generar_nombre_aleatori()
        nickname = input("Introdueix el teu nickname: ")
        self.jugador = Jugador(nickname)
        encertat = False
        while not encertat:
            intent = int(input(f"Endevina el nombre (entre {_MIN} i {_MAX}): "))
            self.jugador.incrementar_encerts()

            if intent == self.nombre_aleatori:
                print(f"Encertat! Has endevinat el nombre en {self.jugador.encerts} intents.")
                self.registrar_encert()
                encertat = True
            elif intent < self.nombre_aleatori:
                print("Massa petit. Torna a intentar-ho.")
            else:
                print("Massa gran. Torna a intentar-ho.")

    def registrar_encert(self):
        with open("hall_of_fame.txt", "a") as f:
            f.write(
                f"{date.today().strftime('%d/%m/%Y')} {self.jugador.nickname} ha trigat en encertar: {self.jugador.encerts}\n")
