from sqlite3 import IntegrityError, OperationalError, Connection

from sqlite_basic.bd.bd_exceptions import ItemAlreadyStored, ItemNotStored
from sqlite_basic.bd.model.persona import Persona

_TABLE_NAME = "persona"
_LIMIT = 100


def create_table(conn, table_name=_TABLE_NAME):
    """
    Crea una taula per demostrar el funcionament
    :param conn: connexió a la bbdd
    :param table_name: nom de la taula
    """
    sql = (
        f"CREATE TABLE {table_name} ("
        f"id INTEGER PRIMARY KEY AUTOINCREMENT,"
        f"nom TEXT,"
        f"cognoms TEXT,"
        f"edat INTEGER,"
        f"email TEXT UNIQUE );"
    )
    try:
        conn.execute(sql)
    except OperationalError as e:
        print(e)


def insert_one(conn: Connection, nom: str, cognoms: str, edat: int, email: str, table_name: str = _TABLE_NAME):
    """
    Inserta un sol registre a la taula persona
    :param conn: objecte connexió
    :param nom: nom
    :param cognoms: cognoms
    :param edat: edat
    :param email: correu electrònic
    :param table_name: nom de la taula (persona)
    """
    sql = f"INSERT INTO {table_name} ('nom', 'cognoms', 'edat', 'email') VALUES (?, ?, ?, ?)"
    try:
        conn.execute(sql, (nom, cognoms, edat, email))
        conn.commit()
    except IntegrityError as e:
        raise ItemAlreadyStored(
            f"{e}: {email} ja està emmagatzemat a la taula {table_name}"
        )


def insert_many(conn: Connection, items: list, table_name: str = _TABLE_NAME):
    """

    :param conn:
    :param items: llista d'elements (dict) preparats per inserció massiva
    :param table_name: nom de la taula (persona)
    :return:
    """
    sql = f"INSERT INTO {table_name} ('nom', 'cognoms', 'edat', 'email') VALUES (?, ?, ?, ?);"
    entries = list()
    for x in items:
        entries.append((x["nom"], x["cognoms"], x["edat"], x["email"]))
    try:
        conn.executemany(sql, entries)
        conn.commit()
    except IntegrityError as e:
        print(
            f"{e}: almenys un {[x['email'] for x in items]} ja està introduït a la taula {table_name}"
        )


def select_one(conn: Connection, attribute_name, where_value, table_name=_TABLE_NAME):
    """
    Selecciona 1 element i retorna un objecte de la classe Persona
    :param conn: connexió
    :param attribute_name: nom de la columna que realitza la cerca
    :param where_value: valor a cercar
    :param table_name: nom de la taula (persona)
    :return: Persona()
    """
    sql = f"SELECT * FROM {table_name} WHERE {attribute_name}= ?;"
    cursor = conn.execute(sql, (where_value,))
    result = cursor.fetchone()
    if result is not None:
        return _to_persona(result)
    else:
        raise ItemNotStored(
            f"No puc llegit l'atribut {attribute_name} perquè no està a la taula {table_name}"
        )


def select_all(conn, limit=_LIMIT, table_name=_TABLE_NAME):
    """
    Selecciona tots els elements d'una llista
    :param conn: connexió
    :param table_name: nom de la taula
    :return: llista d'ojectes de tipus Persona()
    """
    sql = f"SELECT * FROM {table_name} limit {limit};"
    cursor = conn.execute(sql)
    results = cursor.fetchall()
    return list(map(lambda x: _to_persona(x), results))


def update(conn: Connection, where_attribute, where_value, update_attribute, update_value, table_name=_TABLE_NAME):
    """
    Actualtiza un registre de la base de dades
    :param conn: connexió
    :param where_attribute: columna que determina l'element que cerca
    :param where_value: valor a cercar
    :param update_attribute: columna que indica l'element a modificar
    :param update_value: nou valor
    :param table_name: nom de la taula (persona)
    """
    sql = f"UPDATE {table_name} SET {update_attribute}= ? WHERE {where_attribute}= ?;"
    conn.execute(sql, (update_value, where_value))
    conn.commit()


def delete(conn: Connection, where_attribute, where_value, table_name=_TABLE_NAME):
    """
    Elimina un element de la taula
    :param conn: connexió
    :param where_attribute: columna que determina la cerca
    :param where_value: valor que volem eliminat
    :param table_name: nom de la taula (persona)
    """
    sql = f"DELETE FROM {table_name} WHERE {where_attribute} = ?;"
    conn.execute(sql, (where_value,))
    conn.commit()


def _to_persona(from_tuple):
    """
    Converteix una tupla en un objecte Persona()
    :param from_tuple: tupla amb els valors
    :return: un objecte de la classe Persona()
    """
    return Persona(id=from_tuple[0], nom=from_tuple[1], cognoms=from_tuple[2], edat=from_tuple[3], email=from_tuple[4])
