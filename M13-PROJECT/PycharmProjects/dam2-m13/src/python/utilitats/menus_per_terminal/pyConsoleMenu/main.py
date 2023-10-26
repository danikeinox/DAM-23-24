import platform

from consolemenu import *
from consolemenu.items import *


def entrada_dades():
    valor = input("Introdueix un valor: ")
    return valor


def run_main():
    # Crea el menu
    menu = ConsoleMenu("iAgro Systems", "Menú Principal")

    # Create some items

    # MenuItem és la classe base per tota la resta d'ítems. No fa res quan es seleccionada
    menu_item = MenuItem("Menú Ítem")

    # FunctionItem executa una funció quan es seleccionada
    function_item = FunctionItem("Crida a una funció python", entrada_dades)

    # CommandItem executa una ordre al terminal (cal recordar els != sistemes operatius)
    command_item = None
    if platform.system() == 'Linux':
        command_item = CommandItem("Executa una orde en un sistema Linux", "ls -la --color=auto")
    elif platform.system() == 'Windows':
        command_item = CommandItem("Executa una orde en un sistema Windows", "dir /a")
    elif platform.system() == 'Darwin':
        command_item = CommandItem("Executa una orde en un sistema MacOS", "ls -la")

    # SelectionMenu construeix un menu a partir d'una llista (list()) de cadenes (str())
    selection_menu = SelectionMenu(["Element 1", "Element 2", "Element 3"])

    # SubmenuItem permet afegir un menu a altre menu existent
    submenu_item = SubmenuItem("Submenú", selection_menu, menu)

    # Afegim els elements creats al menu
    menu.append_item(menu_item)
    menu.append_item(function_item)
    menu.append_item(command_item)
    menu.append_item(submenu_item)

    # Finalment, mostrem el menu per interactual amb l'usuari/a
    menu.show()


if __name__ == '__main__':
    run_main()
