def bases_numeriques():
    # Decimal
    a = 10
    # Binari
    a = 0b1010
    # Octal
    a = 0o12
    # Hexadecimal
    a = 0xA
    print(f'a: {a}')


def conversions_entre_bases():
    # Conversions entre bases
    # Base Decimal (base 10)
    a = int('23', 10)
    # Base Binario (base 2)
    a = int('10111', 2)
    # Base Octal (bse 8)
    a = int('27', 8)
    # Base Hexadecimal (base 15)
    a = int('17', 16)
    # Base 5
    a = int('344', 5)
    print(f'a: {a}')


def run_main():
    bases_numeriques()
    conversions_entre_bases()


if __name__ == '__main__':
    run_main()
