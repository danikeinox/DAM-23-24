import math
from decimal import Decimal


def run_main():
    # NaN - Not a number (no es un número)
    # NaN no es sensible a majúscules/minúscules
    # NaN es un tipus de dades numèric indefinit
    a = float('NaN')
    print(f'a: {a}')
    print(f'És NaN (not a number)?: {math.isnan(a)}')

    a = Decimal('NaN')
    print(f'a: {a}')
    print(f'Es NaN (not a number)?: {math.isnan(a)}')


if __name__ == '__main__':
    run_main()
