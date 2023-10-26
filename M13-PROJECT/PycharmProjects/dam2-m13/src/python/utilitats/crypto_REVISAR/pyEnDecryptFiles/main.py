import json

from cryptography.fernet import Fernet


def encripta_dades(fitxer_clar, fitxer_enc):
    key = Fernet.generate_key()  # Mètode que crea la clau privada
    with open (fitxer_clar, "rb") as f:  # Obrim el fitxer amb les dades en text clar
        dades = f.read()

    fernet = Fernet(key)  # Inicialitzem el motor per encriptar utitlizant la clau generada
    dades_encriptades = fernet.encrypt(dades)

    with open(fitxer_enc, "wb") as f:
        f.write(dades_encriptades)

    # Per debugar ... no al programa !!! -->   Cada execució genera una clau diferent
    print(key)


def desencripta_dades(fitxer_enc, key_file):
    with open(key_file, "rb") as k:
        key = k.read()

    with open(fitxer_enc, "rb") as f:
        dades_encriptades = f.read()

    fernet = Fernet(key)  # Inicialitzem amb la clau generada

    dades_desencriptades = fernet.decrypt(dades_encriptades)
    config = json.loads(dades_desencriptades)

    # Solament per debug --> eliminar del programa
    print(f'host: {config["host"]}')
    print(f'port: {config["port"]}')
    print(f'database: {config["database"]}')
    print(f'username: {config["username"]}')
    print(f'password: {config["password"]}')


def run_main():
    # encripta_dades("app.conf", "app.enc")
    desencripta_dades("app.enc", "key.file")


if __name__ == '__main__':
    run_main()

