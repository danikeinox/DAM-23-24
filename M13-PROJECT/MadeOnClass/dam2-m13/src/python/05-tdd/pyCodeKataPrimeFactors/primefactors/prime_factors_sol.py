def of(numero):
    factors = []
    candidat = 2
    while numero > 1:
        while (numero % candidat) == 0:
            numero /= candidat
            factors.append(candidat)
        candidat += 1
    return factors


if __name__ == '__main__':
    of(4)


