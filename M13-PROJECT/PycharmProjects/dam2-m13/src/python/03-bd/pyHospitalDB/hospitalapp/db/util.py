from hospitalapp import log_info
from hospitalapp.db.connection import Connection


def importdb(path):
    with open(path, 'r') as f:
        sql = f.read()
    conn = None
    try:
        conn = Connection()
        cursor = conn.cursor()
        print(f"Important... \n{sql}\nFet!\n")
        cursor.execute(sql)
        conn.commit()
    except Exception as e:
        conn.rollback()
        log_info(f"Error al importar la base de dades {e}")
    finally:
        conn.close()
