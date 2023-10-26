"""
    Cal configurar l'entorn
    1.- Afegir el paquet pytest mitjançant pip <pip3 install pytest>
    2.- Configurar un entorn d'execució al pyCharm --> Run --> Run ... --> Edit Configurations
        Afegir (clic al +) i cercar Python Tests --> pytest
        Canviar el nom i indicar la ruta (path) al fitxer

"""


def test_assert_true():
    assert False # Executar i comprovar que el test falla