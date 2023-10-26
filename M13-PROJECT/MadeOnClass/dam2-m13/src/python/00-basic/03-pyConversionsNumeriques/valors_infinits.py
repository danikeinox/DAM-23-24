import math
from decimal import Decimal


def run_main():
    infinit_positiu = float('inf')
    print(f'Infinit positiu: {infinit_positiu}')
    print(f'És infinit?: {math.isinf(infinit_positiu)}')
    infinit_negatiu = float('-inf')
    print(f'Infinit negatiu: {infinit_negatiu}')
    print(f'És infinit?: {math.isinf(infinit_negatiu)}')

    # Mòdul math
    infinit_positiu = math.inf
    print(f'Infinit positiu: {infinit_positiu}')
    print(f'És infinit?: {math.isinf(infinit_positiu)}')
    infinit_negatiu = -math.inf
    print(f'Infinit negatiu: {infinit_negatiu}')
    print(f'És infinit?: {math.isinf(infinit_negatiu)}')

    # Mòdul Decimal:
    infinit_positiu = Decimal('Infinity')
    print(f'Infinit positiu: {infinit_positiu}')
    print(f'És infinit?: {math.isinf(infinit_positiu)}')
    infinit_negatiu = Decimal('-Infinity')
    print(f'Infinit negatiu: {infinit_negatiu}')
    print(f'És infinit?: {math.isinf(infinit_negatiu)}')


if __name__ == '__main__':
    run_main()
