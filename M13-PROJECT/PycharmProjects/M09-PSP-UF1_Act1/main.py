from classes.cesar import Cesar


def menu():
    while True:
        print("1. Activitat 1 Cèsar")
        print("2. Activitat 2 Cèsar")
        print("3. Activitat 3 Cèsar")
        print("4. Sortir")
        choice = int(input("Indica que activitat vols executar: "))
        if choice == 1:
            key = 7
            value = "La sort està tirada"
            cesar = Cesar(key, value)
            print(cesar.encryptCesar())
            print(cesar.decryptCesar())
        elif choice == 2:
            while True:
                print("1. Encriptar")
                print("2. Desencriptar")
                print("3. Sortir")
                choice = int(input("Enter your choice: "))
                if choice == 1:
                    key = int(input("Afegeix la key secreta: "))
                    value = input("Afegeix el text a encriptar: ")
                    cesar = Cesar(key, value)
                    print(cesar.encryptCesar())
                elif choice == 2:
                    key = int(input("Afegeix la key secreta: "))
                    value = input("Afegeix el text a desencriptar: ")
                    cesar = Cesar(key, value)
                    print(cesar.decryptCesar())
                elif choice == 3:
                    # Afegeix al codi anterior una nova utilitat que permeti llegir un conjunt de paraules
                    # separades per <ENTER> emmagatzemades en un fitxer de text i que generi un nou fitxer
                    # amb totes les paraules encriptades.
                    pass
                elif choice == 4:
                    exit()
                else:
                    print("Sel·lecció incorrecta")
                    menu()
        elif choice == 3:
            exit()
        else:
            print("Sel·lecció incorrecta")
            menu()
        # MENU 2


if __name__ == '__main__':
    print("Welcome to Caesar Cipher")
    with open("logotype.txt") as f:
        key = str(f.read())
    print("Enter key and value to encrypt or decrypt")
    menu()
