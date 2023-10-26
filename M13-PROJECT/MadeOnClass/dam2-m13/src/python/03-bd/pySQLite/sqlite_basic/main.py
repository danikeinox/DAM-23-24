from sqlite_basic.bd.connection import connect_to_db, disconnect_from_db
from sqlite_basic.bd.model.persona_dao import (
    insert_many, insert_one, create_table,
    select_all, select_one, update, delete
)


def mock_items():
    """
    Crea elements fake. Útil per inicialitzar taules amb dades
    :return: llista d'elements de la taula
    """
    return [
        {"nom": "Julia", "cognoms": "Manero", "edat": 20, "email": "jmanero@gmail.com"},
        {"nom": "Felip", "cognoms": "Cases", "edat": 20, "email": "felip@gmail.com"},
        {"nom": "Noelia", "cognoms": "Miró", "edat": 20, "email": "noelia@gmail.com"},
        {"nom": "Maria", "cognoms": "de la O", "edat": 20, "email": "maria@gmail.com"},
    ]


def main():
    # db_name = "base_de_dades"  # None per in-memory
    db_name = None  # None per in-memory
    table_name = "persona"  # nom de la taula que estem treballant
    conn = connect_to_db(db=db_name)  # in-memory database
    create_table(conn=conn, table_name=table_name)
    insert_one(conn=conn, nom='Pep', cognoms='Moratò Blau', edat=25, email="pep@morato.cat")
    insert_many(conn=conn, items=mock_items())
    print(f"\nSelecció d'un sol element per [email, str]")
    p1 = select_one(conn=conn, attribute_name='email', where_value='pep@morato.cat')
    print(p1)
    print(f"\nSelecció d'un sol element per [id, int]")
    p2 = select_one(conn=conn, attribute_name='id', where_value=4)  # Noelia
    print(f"\nObtenció de tots els registres de la BBDD")
    persones = select_all(conn=conn)
    print(persones)
    print(f"\nActualitzem el primer element")
    update(conn=conn, table_name=table_name, where_attribute='id', where_value=1, update_attribute='nom', update_value="Joan")
    print(f"\nObtenció de tots els registres de la BBDD")
    persones = select_all(conn=conn)
    print(persones)
    print(f"\nEliminem el primer element")
    delete(conn=conn, table_name=table_name, where_attribute='id', where_value=1)
    print(f"\nObtenció de tots els registres de la BBDD")
    persones = select_all(conn=conn)
    print(persones)
    disconnect_from_db(conn=conn, db=db_name)


if __name__ == '__main__':
    main()
