import sys
from classes.menu_ineractiu import MenuInteractiu
from classes.game import Game


def run():
    print("Benvingut a Hangman!")
    game = Game()
    tria = False
    while tria is not True:
        MenuInteractiu.mostrar_menu()
        opcio = input("Selecciona una opció: ")
        print("\n")
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
