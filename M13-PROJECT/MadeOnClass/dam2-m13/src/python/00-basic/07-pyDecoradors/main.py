# Decoradors amb arguments
# Un decorador es una funció que rep una funció i retorna, almenys, una funció (funció decorada)
# Ho utilitzem para estendre la funcionalitat d'una funció
# 1. Funció decorador (a)
# 2. Funció a decorar (b)
# 3. Funció decorada  (c)
# a(b) -> c
def funcio_decorador_a(funcio_a_decorar_b):
    def funcio_decorada_c(*args, **kwargs):
        print('Abans i des de la funció_decorada_c')
        print(f'\targs: {args}')
        print(f'\tkwargs: {kwargs}')
        resultat = funcio_a_decorar_b(*args, **kwargs)
        print('Desprès i des de la funció_decorada_c')
        return resultat

    return funcio_decorada_c


@funcio_decorador_a
def sumar(a, b):
    return a + b


def run_main():
    resultat = sumar(5, 6)
    print(f'Resultat suma: {resultat}')


if __name__ == '__main__':
    run_main()


