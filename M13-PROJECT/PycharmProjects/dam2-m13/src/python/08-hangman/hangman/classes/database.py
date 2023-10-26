import psycopg2

# Configura la conexión a la base de datos PostrgreSQL
def __paraules_bd(quantitat=_MIN):
    def _obte_connexio():
        return database.connectar_bd()

    connexio = _obte_connexio()
    paraules = []
    try:
        with connexio.cursor() as cursor:
            cursor.execute("SELECT paraula FROM tbl_paraules ORDER BY RANDOM() LIMIT %s;", (quantitat,))
            paraules = [paraula[0] for paraula in cursor.fetchall()]
    except psycopg2.Error as e:
        print(f"Error al obtenir la llista de paraules: {e}")
        return _PARAULES
    finally:
        if connexio:
            connexio.close()
        return paraules
