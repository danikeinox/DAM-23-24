from datetime import datetime

from bd.connexio import Connexio
from utils.logger_base import log
from model.persona import Persona
from model.persona_dao import PersonaDAO
from bd.pool_cursor import PoolCursor


# Exemple per provar la pool de connexions
def test_pool():
    c1 = Connexio.get_connection()
    Connexio.free_connection(c1)
    c2 = Connexio.get_connection()
    c3 = Connexio.get_connection()
    c4 = Connexio.get_connection()
    c5 = Connexio.get_connection()
    c6 = Connexio.get_connection()


# Exemple per provar el cursor
def test_pool_cursor(table):
    with PoolCursor() as cursor:
        cursor.execute(f'SELECT * FROM {table}')
        print(cursor.fetchall())


# Comprovar que CRUD es operatiu
def test_crud():
    # Insertar un registre
    now = datetime.now().strftime('%Y-%m-%d %H:%M:%S')
    p1 = Persona(nom='Pep', cognoms='Martinez', login='pmartinez', adreca='Avinguda Tarragona, 15',
                 codi_postal='08720', ciutat='Vilafranca', data_naixement=now)
    lastid = PersonaDAO.insert(p1)
    log.debug(f"La clau de l'últim registre és: {lastid}")

    # Actualitzar un registre
    p1 = Persona(id_persona=7, nom='Juan Carles', cognoms='Juarez', login='jcjuarez')
    updated = PersonaDAO.update(p1)
    log.debug(f'Persones actualitzades: {updated}')

    # Eliminar un registro
    p1 = Persona(id_persona=lastid)
    deleted = PersonaDAO.delete(p1)
    log.debug(f'Persones eliminades: {deleted}')

    # Seleccionar objetos
    persones = PersonaDAO.select()
    for p in persones:
        log.debug(p)


# main program
def run_main():
    # test_pool()
    # test_pool_cursor ('tbl_color')
    test_crud()


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    run_main()
