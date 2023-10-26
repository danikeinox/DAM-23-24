"""
    Per afegir la funcionalitat de connector mariadb cal executar des de terminal o des de l'IDE
        # pip install mariadb

    Després solament hem d'importar el mòdul de mariadb
"""
import mariadb


def connect():
    conn = None
    # Connexió a la BBDD mariaDB
    try:
        conn = mariadb.connect(
            user="X->ask<-X",
            password="X->ask<-X",
            host="X->ask<-X",
            port=3306,
            database="X->ask<-X"
        )
    except mariadb.Error as e:
        print(f"Error connectant a la BD mariaDB: {e}")
    return conn


# Obtenim tots els registres d'una taula
def get_all_colors(connection):
    cursor = connection.cursor()  # L'objecte cursor emmagatzemarà el resultat de l'operació SQL
    sql = 'SELECT * FROM tbl_color'  # Consulta de selecció
    cursor.execute(sql)  # Execució de la consulta
    reg = cursor.fetchall()  # Volem tots els registres de la taula
    return reg


#  Obtenim solament 1 registre de la taula (passat per paràmetre)
#  Amb with el codi es més fàcil de llegir ;-)
def get_color(connection, id_color):
    with connection:
        with connection.cursor() as cursor:
            # sql = 'SELECT * FROM tbl_color WHERE id = ?'  # Consulta de selecció (Opció 1)
            # cursor.execute(sql, id_color)  # Execució de la consulta (Opció 1)
            sql = 'SELECT * FROM tbl_color WHERE id = %(id)s'  # Consulta de selecció (Opció 2)
            cursor.execute(sql, {'id': id_color})  # Execució de la consulta (Opció 2)
            reg = cursor.fetchone()  # Volem solament 1 dels registres de la taula
    return reg


#  Obtenim solament els registres de la taula que volem (passats per paràmetre)
#  Amb with el codi es més fàcil de llegir ;-)
def get_colors(connection, id_colors):
    with connection:
        with connection.cursor() as cursor:
            # id_colors és una tupla
            # Cal ajustar la consulta una mica per adaptar-la (posem tants %s com elements tingui la tupla)
            sql = "SELECT * FROM tbl_color WHERE id IN ({color_list})".format(color_list=', '.join(['%s'] * len(id_colors)))
            print(sql)
            cursor.execute(sql, id_colors)  # Execució de la consulta
            reg = cursor.fetchall()  # Volem solament 1 dels registres de la taula
    return reg


#  Imprimeix tots els registres de la taula
def print_all_colors(conn):
    colors = get_all_colors(conn)  # Obtenim tots els registres de la taula
    if colors:
        print(colors)
    else:
        print("No hi ha cap resultat")


# Imprimeix solament 1 registre
def print_color(conn, id_color):
    color = get_color(conn, id_color)  # Obtenim solament 1 resultat passat com argument
    if color:
        print(color)
    else:
        print("No hi ha cap resulat")


# Imprimeix un conjunt de colors
def print_colors(conn, id_colors):
    colors = get_colors(conn, id_colors)  # Obtenim tots els registres de la taula
    if colors:
        for color in colors:
            print(color)
    else:
        print("No hi ha cap resultat")


# Main
def run_main():
    conn = connect()  # Obtenim un objecte connexió
    # print_all_colors(conn)
    # print_color(conn, 1)
    tupla = (1, 3)
    print_colors(conn, tupla)
    # conn.close()


if __name__ == '__main__':
    run_main()
