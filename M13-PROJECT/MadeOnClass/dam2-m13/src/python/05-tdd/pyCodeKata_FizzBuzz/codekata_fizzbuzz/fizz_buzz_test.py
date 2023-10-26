from main import fizz_buzz


def test_fizzbuzz_retorna_1_si_passo_1():
    val_esp = "1"
    val_ret = fizz_buzz(1)
    assert val_ret == val_esp
