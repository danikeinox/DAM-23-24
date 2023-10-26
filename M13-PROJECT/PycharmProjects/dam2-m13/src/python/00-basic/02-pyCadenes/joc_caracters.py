# ASCII
def joc_ascii():
    print(f'\nASCII')
    caracter = chr(65)
    print('A majúscula:', caracter)
    caracter = chr(64)
    print('Símbol @:', caracter)
    caracter = chr(97)
    print('a minúscula:', caracter)


def amb_byte():
    # caràcters byte
    caracters_en_bytes = b'Hola Mon'  # Els bytes solament utilitzen ASCII (accents no viables)
    print(caracters_en_bytes)

    missatge = b'Hola Mon'
    print(missatge[0])  # Ens retorna el valor en byte del primer caràcter 72 --> lletra H en ASCII
    print(chr(missatge[0]))  # Convertim el valor 72 ASCII i així obtenim el caràcter H

    llista = missatge.split()
    print(llista)


# Conversió entre str i bytes i viceversa
def convertir_str_a_bytes_i_vice():
    print(f'Conversió entre str i bytes i viceversa')
    # Convertir str a bytes
    string = 'Programació amb Python'  # El joc de caràcters per defecte és utf-8. Aquest reconeix els accents
    print('string original:', string)

    byte = string.encode('UTF-8')  # Podriem ometre 'UTF-8' perquè és el joc per defecte
    print('bytes codificats:', byte)

    # Convertir bytes a str
    string2 = byte.decode('UTF-8')
    print('string decodificat:', string2)
    print(f'Són iguals: {string == string2}')


# Per defecte python utilitza unicode
def joc_unicode():
    print(f'UNICODE')
    print('Hola\u0020Món')
    print('Notació simple:', '\u0041')
    print('Notació estesa:', '\U00000041')
    print('Notació hexadecimal', '\x41')
    print('Cor:', '\u2665')
    print('Smiley:', '\U0001f600')
    print('Serp:', '\U0001F40D')


def run_main():
    joc_unicode()
    joc_ascii()
    amb_byte()
    convertir_str_a_bytes_i_vice()


if __name__ == '__main__':
    run_main()
