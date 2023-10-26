from una_classe import UnaClasse


def run_main():
    print(UnaClasse.__doc__)
    print(UnaClasse.__init__.__doc__)
    print(UnaClasse.metode.__doc__)
    print(UnaClasse.metode)
    print(type(UnaClasse.metode))


if __name__ == '__main__':
    run_main()
