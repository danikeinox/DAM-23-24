import unittest

from primefactors import prime_factors_sol


class TestPrimeFactors(unittest.TestCase):
    def test_when_request_prime_factors_of_1_then_expected_result_is_1(self):
        numero = 1
        esperat = []
        resultat = prime_factors_sol.of(numero)
        self.assertEqual(esperat, resultat)

    def test_when_request_prime_factors_of_2_then_expected_result_is_2(self):
        numero = 2
        esperat = [2]
        resultat = prime_factors_sol.of(numero)
        self.assertEqual(esperat, resultat)

    def test_when_request_prime_factors_of_3_then_expected_result_is_3(self):
        numero = 3
        esperat = [3]
        resultat = prime_factors_sol.of(numero)
        self.assertEqual(esperat, resultat)

    def test_when_request_prime_factors_of_4_then_expected_result_is_2_2(self):
        numero = 4
        esperat = [2, 2]
        resultat = prime_factors_sol.of(numero)
        self.assertEqual(esperat, resultat)

    def test_when_request_prime_factors_of_5_then_expected_result_is_5(self):
        numero = 5
        esperat = [5]
        resultat = prime_factors_sol.of(numero)
        self.assertEqual(esperat, resultat)

    def test_when_request_prime_factors_of_6_then_expected_result_is_2_3(self):
        numero = 6
        esperat = [2, 3]
        resultat = prime_factors_sol.of(numero)
        self.assertEqual(esperat, resultat)

    def test_when_request_prime_factors_of_7_then_expected_result_is_7(self):
        numero = 7
        esperat = [7]
        resultat = prime_factors_sol.of(numero)
        self.assertEqual(esperat, resultat)

    def test_when_request_prime_factors_of_8_then_expected_result_is_2_2_2(self):
        numero = 8
        esperat = [2, 2, 2]
        resultat = prime_factors_sol.of(numero)
        self.assertEqual(esperat, resultat)

    def test_when_request_prime_factors_of_9_then_expected_result_is_3_3(self):
        numero = 9
        esperat = [3, 3]
        resultat = prime_factors_sol.of(numero)
        self.assertEqual(esperat, resultat)

    def test_when_request_prime_factors_of_75_then_expected_result_is_3_5_5(self):
        numero = 75
        esperat = [3, 5, 5]
        resultat = prime_factors_sol.of(numero)
        self.assertEqual(esperat, resultat)

    def test_when_request_prime_factors_of_175_then_expected_result_is_5_5_7(self):
        numero = 175
        esperat = [5, 5, 7]
        resultat = prime_factors_sol.of(numero)
        self.assertEqual(esperat, resultat)
