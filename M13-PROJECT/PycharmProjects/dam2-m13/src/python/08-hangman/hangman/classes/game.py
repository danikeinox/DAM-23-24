import random
from datetime import date

import requests

from .jugador import Jugador

def database_paraules():

def get_paraules():
    wordlist_url = "https://gitlab.com/rnadalb/dam2-m13/-/raw/main/src/python/08-hangman/paraules.txt"
    try:
        response = requests.get(wordlist_url)
        if response.status_code == 200:
            paraules = response.text.splitlines()
            return paraules
        else:
            print("No s'ha pogut obtenir la llista de paraules. Códi de resposta:", response.status_code)
    except requests.exceptions.RequestException as e:
        print("Error al fer la solicitut:", e)
    return


class Game:
    def __init__(self):
        self.random_word = ""
        self.palabra_oculta = ""
        self.jugador = None

    def generar_random_word(self):
        self.random_word = random.choice(get_paraules())
        self.palabra_oculta = "_" * len(self.random_word)

    def jugar(self):
        self.generar_random_word()
        nickname = input("Introdueix el teu nickname: ")
        self.jugador = Jugador(nickname)
        palabra_encertada = False
        MAX_INTENTS = 5

        while not palabra_encertada and self.jugador.intents < MAX_INTENTS:
            print("Palabra oculta:", self.palabra_oculta, f"{self.jugador.intents}/{MAX_INTENTS}")
            intent = input("Introdueix una lletra o paraula: ")

            if intent in self.random_word:
                # Adivinaste una letra
                for i in range(len(self.random_word)):
                    if self.random_word[i] == intent:
                        self.palabra_oculta = self.palabra_oculta[:i] + intent + self.palabra_oculta[i + 1:]

                if intent == self.random_word:
                    palabra_encertada = True
                    self.palabra_oculta = self.palabra_oculta + intent + self.palabra_oculta
                    print("Has encertat la paraula!")
                else:
                    print("Has encertat una lletra!")

            else:
                print("Aquesta lletra no és a la paraula.")
                self.jugador.incrementar_intents()

        if not palabra_encertada:
            print(f"Has superat el límit d'intents {self.jugador.intents}/{MAX_INTENTS}. La paraula correcta era:",
                  self.random_word)
        else:
            self.registrar_encert()
            print(
                f"{date.today().strftime('%d/%m/%Y')} {self.jugador.nickname} ha encertat la paraula \"{self.random_word}\" amb {self.jugador.intents} fallos\n")

    def registrar_encert(self):
        with open("hall_of_fame.txt", "a") as f:
            f.write(
                f"{date.today().strftime('%d/%m/%Y')} {self.jugador.nickname} ha encertat la paraula amb {self.jugador.intents} fallos\n")
