import sqlite3

DB_NAME = "base_de_dades"


def connect_to_db(db=None):
    """Connecta a una base de daes SQLite. Si la BBDD no existeix la crea.

    Obre una connexió a una base de dades SQLite (en fitxer o a memòria - in-memory DB)
    Si la BBDD és accedida per múltiples connexions i algun dels processos modifica la BBDD,
    la BBDD romandrà bloquejada fins que la transacció estigui finaltizada.

    Parameters
    ----------
    @db : str
        nom de la base de dades (sense la extensió .sqlite). Si és None, crea una BBDD in-memory

    Returns
    -------
    connection : sqlite3.Connection
        objecte connexió
    """
    if db is None:
        mydb = ":memory:"
        print("Nova connexió in-memory (SQLite DB)...")
    else:
        mydb = f"{db}.sqlite"
        print("Nova connexió a SQLite DB...")
    connection = sqlite3.connect(mydb)
    return connection


def disconnect_from_db(conn=None, db=None):
    """
    Desconnecta de la BBDD
    :param conn: connexió a tancar
    :param db: nom de la base de dades
    """
    if db is not DB_NAME:
        print("Estàs intentant desconnectar de la base de dades equivocada")
    if conn is not None:
        conn.close()


if __name__ == "__main__":
    print("Don't do that, dude !")
