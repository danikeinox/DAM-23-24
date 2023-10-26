import logging

from postgres_app.db.connection import Connection
from postgres_app.db.model.usuari import Usuari


def main():
    conn = None
    try:
        conn = Connection()
        sql = f"SELECT * from usuari ORDER BY id_usuari DESC;"
        cursor = conn.cursor()
        cursor.execute(sql)
        usuaris = Usuari.to_usuari(cursor.fetchall())
        print(usuaris)
    except Exception as e:
        logging.info(f'ERROR: {e}')
    finally:
        if conn:
            conn.close()


if __name__ == '__main__':
    main()
