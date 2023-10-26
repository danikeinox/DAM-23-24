"""
Tests per la classe Treballador
"""
import unittest

from treballador import Treballador

NOM: str = "Luke"
ID_TREBALLADOR: int = 13579

treballador_a_testar = Treballador(nom=NOM, id_treballador=ID_TREBALLADOR)


class TestCalculSouTreballador(unittest.TestCase):
    """Test per al mètode calcula_dou de la classe Treballador."""

    def test_01_atributs_treballador(self):
        """Ens assegurem que els atributs de la classe són els esperats."""
        expected_attributes = {
            "nom": NOM,
            "id_treballador": ID_TREBALLADOR,
            "ratio_nomina": 100.0,
            "hores_dedicacio": 0.0,
            "nomina": 1000.0,
            "comissio": 100.0,
            "contractes_tancats": 0,
        }
        for key, value in expected_attributes.items():
            value_to_test = getattr(treballador_a_testar, key)
            with self.subTest(attribute=key, expected=value, actual=value_to_test):
                self.assertEqual(value, value_to_test)

    def test_02_el_sou_sempre_es_float(self):
        """El sou sempre ha de retornar un float."""
        self.assertIsInstance(treballador_a_testar.calcula_sou(), float)

    def test_03_sou_sense_hores_ni_comissio(self):
        """
        Test: comprovem que el sou es calcula correctament si:
            contractes_tancats = cap
            hores dedicades = cap
        """
        treballador_a_testar.contractes_tancats = 0
        treballador_a_testar.hores_dedicacio = 0
        self.assertAlmostEqual(treballador_a_testar.calcula_sou(), 1000.0)

    def test_04_amb_hores_sense_comissio(self):
        """
        Test: comprovem que el sou es calcula correctament si:
            contractes_tancats = cap
            hores dedicades = 10
        """
        treballador_a_testar.hores_dedicacio = 10.0
        treballador_a_testar.comissio = 0.0
        self.assertAlmostEqual(treballador_a_testar.calcula_sou(), 2000.0)

    def test_05_amb_hores_amb_comissio(self):
        """
        Test: comprovem que el sou es calcula correctament si:
            contractes_tancats = 10
            hores dedicades = 10
        """
        treballador_a_testar.hores_dedicacio = 10.0
        treballador_a_testar.contractes_tancats = 10
        treballador_a_testar.comissio = 100.0
        self.assertAlmostEqual(treballador_a_testar.calcula_sou(), 3000.0)

    def test_06_amb_hores_i_contractes_sense_comissio(self):
        """
        Test: comprovem que el sou es calcula correctament si
            contractes_tancats = 10
            hores dedicades = 10
            comissio = 0.0
        """
        treballador_a_testar.hores_dedicacio = 10.0
        treballador_a_testar.contractes_tancats = 10
        treballador_a_testar.comissio = 0.0

        self.assertAlmostEqual(treballador_a_testar.calcula_sou(), 2000.0)


if __name__ == "__main__":
    unittest.main()
