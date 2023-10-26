import unittest

from bdtesting.bd.bdpostgresql import BDPostgreSQL as Bd
from bdtesting.model.persona import Persona
from bdtesting.model.persona_dao import PersonaDAO
import config_testing


class TestPersonaDAO(unittest.TestCase):

    @classmethod
    def setUpClass(cls) -> None:
        print(f'setUpClass(): {config_testing._LAST_ID}')
        print(f'setUpClass() executat...')

    def setUp(self) -> None:
        print(f'setup(): {config_testing._LAST_ID}')
        print(f'setUp() executat...')

    def tearDown(self) -> None:
        print(f'tearDown(): {config_testing._LAST_ID}')
        print(f'tearDown() executat...')

    @classmethod
    def tearDownClass(cls) -> None:
        print(f'tearDownClass(): {config_testing._LAST_ID}')
        print(f'tearDownClass() executat...')

    def test_01_connection(self):
        print(f'test_01_connection() executat...')
        _con = Bd.get_connection()
        self.assertEqual(_con.info.status, 0, "test_01_connection() correcte")

    def test_02_select_all(self):
        print(f'test_02_select_all() executat...')
        persones = PersonaDAO.select()
        self.assertFalse(persones is None, "test_select_all() correcte")

    def test_03_select_by_id(self):
        print(f'test_03_select_by_id() executat...')
        persona = PersonaDAO.select_by_id(config_testing._ID_PERSONA)
        print(f'codi: {persona[0]}')
        self.assertEqual(config_testing._ID_PERSONA, persona[0], "test_select_by_id() correcte")

    def test_04_update(self):
        p = Persona("Dolors",
                    "Forts",
                    "C/ La Panxa",
                    "08720",
                    "Vilafranca del Penedès",
                    "2021-11-28 18:30:00",
                    "dforts",
                    "5678",
                    config_testing._ID_PERSONA)
        PersonaDAO.update(p)
        updated_p = Persona.from_record(PersonaDAO.select_by_id(config_testing._ID_PERSONA))
        self.assertEqual(p, updated_p, "test_04_update() correcte")
        print(f'test_04_update() executat...')

    def test_05_insert(self):
        print(f'test_05_insert() executat...')
        new_p = Persona("Emiliano",
                        "Paredes",
                        "C/ Zapata",
                        "08720",
                        "Vilafranca del Penedès",
                        "2021-11-28 18:50:00",
                        "eparedes",
                        "9101")
        config_testing._LAST_ID = PersonaDAO.insert(new_p)
        new_p.id_persona = config_testing._LAST_ID
        inserted_p = Persona.from_record(PersonaDAO.select_by_id(config_testing._LAST_ID))
        self.assertEqual(inserted_p, new_p, "test_05_insert() correcte")

    def test_06_delete(self):
        print(f'test_delete() executat...')
        print(config_testing._LAST_ID)
        PersonaDAO.delete(config_testing._LAST_ID)
        self.assertIsNone(PersonaDAO.select_by_id(config_testing._LAST_ID))


if __name__ == '__main__':
    unittest.main()
