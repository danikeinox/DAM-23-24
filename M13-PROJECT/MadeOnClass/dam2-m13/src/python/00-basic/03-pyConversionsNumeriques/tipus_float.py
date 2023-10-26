def run_main():
    a = 3.0
    # El constructor float pot rebre int i str
    a = float(10)
    a = float('10')
    # print(f'a: {a:.2f}')
    # Notació exponencial (valors positius o negatius)
    a = 3e5
    a = 3e-5
    # print(f'a: {a:.5f}')
    # Qualsevol càlcul que involucri un float, obté un float
    a = 4 + 5.0
    print(a)
    print(type(a))


if __name__ == '__main__':
    run_main()
