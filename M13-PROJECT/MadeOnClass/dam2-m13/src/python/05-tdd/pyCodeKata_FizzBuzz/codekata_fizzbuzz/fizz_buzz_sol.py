def es_multiple(valor, mod):
    return (valor % mod) == 0


def fizz_buzz(valor):
    if es_multiple(valor, 3):
        if es_multiple(valor, 5):
            return "FizzBuzz"
        return "Fizz"

    if es_multiple(valor, 5):
        return "Buzz"

    return str(valor)


def run_test(valor_passat, valor_esperat):
    valor_retornat = fizz_buzz(valor_passat)
    assert valor_retornat == valor_esperat


def test_fizzbuzz_retorna_1_si_passo_1():
    run_test(1, "1")


def test_fizzbuzz_retorna_2_si_passo_2():
    run_test(2, "2")


def test_fizzbuzz_retorna_fizz_si_passo_3():
    run_test(3, "Fizz")


def test_fizzbuzz_retorna_buzz_si_passo_5():
    run_test(5, "Buzz")


def test_fizzbuzz_retorna_fizz_si_passo_6_o_multiple_de_3():
    run_test(6, "Fizz")


def test_fizzbuzz_retorna_buzz_si_passo_10_o_multiple_de_5():
    run_test(10, "Buzz")


def test_fizzbuzz_retorna_fizzbuzz_si_passo_15_o_multiple_de_3_i_de_5():
    run_test(15, "FizzBuzz")
