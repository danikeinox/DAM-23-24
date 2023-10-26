import sys

from guess_game.classes.game import Game
from guess_game.classes.menu_ineractiu import MenuInteractiu


def run():
    game = Game()
    tria = False
    while tria is not True:
        MenuInteractiu.mostrar_menu()
        opcio = input("Selecciona una opció: ")
        # Comprova la versió de python i si és major que 3.10 utilitza el match
        # És una manera de fer més compatible l'aplicació
        # Òbviament podria fer-se solament amb if i estalviar-nos el match per garantir
        # la compatibilitat. Solament és un exemple.
        if sys.version_info[0] == 3 and sys.version_info[1] >= 10:
            match opcio:
                case "1":
                    game.jugar()
                case "2":
                    MenuInteractiu.veure_puntuacions()
                case "3":
                    tria.__eq__(True)
                    break
                case _:
                    print("Opció no válida. Torna a intentar-ho.")
        else:
            if opcio == "1":
                game.jugar()
            elif opcio == "2":
                MenuInteractiu.veure_puntuacions()
            elif opcio == "3":
                tria.__eq__(True)
                break
            else:
                print("Opció no válida. Torna a intentar-ho.")


if __name__ == '__main__':
    run()
