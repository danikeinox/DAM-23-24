from classes.cesar import Cesar


def menu():
    while True:
        with open("logotype.txt") as f:
            logotype = str(f.read())
            print(logotype)
        print("1. Activitat 1 Cesar")
        print("2. Activitat 2 Cesar")
        print("3. Activitat 3 Cesar")
        print("4. Sortir")
        choice = int(input("Indica que activitat vols executar: "))
        if choice == 1:
            key = 7
            value = "La sort està tirada"
            cesar = Cesar(key, value.lower())
            print("Text original: " + value)
            print("Text encriptat: " + cesar.encryptCesar())
            cesar = Cesar(key, cesar.encryptCesar())
            print("Text desencriptat: " + cesar.decryptCesar())
        elif choice == 2:
            while True:
                print("1. Encriptar")
                print("2. Desencriptar")
                print("3. Sortir")
                choice = int(input("Enter your choice: "))
                if choice == 1:
                    while True:
                        try:
                            key = int(input("Afegeix la key secreta: "))
                            value = input("Afegeix el text a encriptar: ")
                            cesar = Cesar(key, value.lower())
                            print(cesar.encryptCesar())
                            break
                        except ValueError:
                            print("Error: Introdueix una key valida (Numero)")
                elif choice == 2:
                    while True:
                        try:
                            key = int(input("Afegeix la key secreta: "))
                            value = input("Afegeix el text a desencriptar: ")
                            cesar = Cesar(key, value)
                            print(cesar.decryptCesar())
                            break
                        except ValueError:
                            print("Error: Introdueix una key valida (Numero)")
                elif choice == 3:
                    break
                else:
                    print("Sel·lecció incorrecta")
        elif choice == 3:
            while True:
                print("1. Encriptar")
                print("2. Desencriptar")
                print("3. Sortir")
                choice = int(input("Enter your choice: "))
                if choice == 1:
                    with open("text_values.txt", "w") as f:
                        f.write("")
                    with open("text_values_encrypted.txt", "w") as f:
                        f.write("")
                    key = int(input("Afegeix la key secreta: "))
                    print("Afegeix el text a encriptar (Dona <enter> amb text en blanc per finalitzar): ")
                    value = input("> ")
                    while value != "":
                        cesar = Cesar(key, value)
                        with open("text_values.txt", "a") as f:
                            f.write(str(cesar.value) + "\n")
                        with open("text_values_encrypted.txt", "a") as f:
                            f.write(str(cesar.encryptCesar()) + "\n")
                        value = input("> ")
                elif choice == 2:
                    key = int(input("Afegeix la key secreta: "))
                    with open("text_values_decrypted.txt", "w") as f:
                        f.write("")
                    for line in open("text_values_encrypted.txt", "r"):
                        cesar = Cesar(key, line.strip())
                        with open("text_values_decrypted.txt", "a") as f:
                            f.write(str(cesar.decryptCesar()) + "\n")
                    with open("text_values_decrypted.txt", "r") as f:
                        print("\n" + f.read())
                elif choice == 3:
                    break
                else:
                    print("Sel·lecció incorrecta")
        elif choice == 4:
            exit()
        else:
            print("Sel·lecció incorrecta")
            menu()


if __name__ == '__main__':
    menu()
