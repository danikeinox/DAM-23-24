import unittest

from primefactors import prime_factors


class TestPrimeFactors(unittest.TestCase):
    def test_when_request_prime_factors_of_1_then_expected_result_is_1(self):
        numero = 1
        esperat = []
        resultat = prime_factors.of(numero)
        self.assertEqual(esperat, resultat)
