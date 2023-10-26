from DAOHelper import DAOHelper


# Inserta un valor/s en una taula i retorna el seu identificador (PK) o el nombre de registres inserits
# Exemples:
#       rowid = insert('tbl_color', 'color', ('GRANA',))
#       rowid = insert('tbl_productes', 'nom, preu, existencies', ('Monitor ACER', 255.99, 10))
#       dades = [
#           ('Monitor ACER', 100.99, 30),
#           ('Monitor ASUS', 200.99, 20),
#           ('Monitor DELL', 300.99, 10),
#       ]
#       rows = insert('tbl_productes', 'nom, preu, existencies', dades, True) # Insereix 3 registres
def insert(table, attributes, values, multi=False):
    try:
        with DAOHelper() as conn:
            with conn.cursor() as cursor:
                qry = f'INSERT INTO {table} ({attributes}) VALUES {values}'
                if multi:
                    qry = qry.replace('[', '').replace(']', '')
                    cursor.execute(qry)
                else:
                    if len(values) > 1:
                        cursor.execute(qry)
                    else:
                        qry = f'INSERT INTO {table} ({attributes}) VALUES (?)'
                        cursor.execute(qry, values)
                conn.commit()
    except Exception as e:
        conn.rollback()
        print(f'Error: {e}')
    return cursor.rowcount if multi else cursor.lastrowid


# Actualitza un registre d'una taula determinada
def update(table, attribute, new_value, primary_key_value, primary_key='id'):
    with DAOHelper() as conn:
        with conn.cursor() as cursor:
            qry = f'UPDATE {table} SET {attribute} = ? WHERE {primary_key} = ?'
            dades = (new_value, primary_key_value)
            cursor.execute(qry, dades)
            conn.commit()
            row = cursor.rowcount
    return row


# Actualitza diversos registre d'una taula determinada
def update_many(table, attributes, values, primary_key='id'):
    with DAOHelper() as conn:
        with conn.cursor() as cursor:
            at = ''
            for a in attributes:
                at += a + " = ?,"
            at = at[:-1]  # Eliminem l'últim caràcter (la , final)
            qry = f'UPDATE {table} SET {at} WHERE {primary_key} = ?'
            cursor.executemany(qry, values)
            conn.commit()
            return cursor.rowcount


# Elimina un registre d'una taula determinada determinat
def delete(table, attribute, value):
    with DAOHelper() as conn:
        with conn.cursor() as cursor:
            qry = f'DELETE FROM {table} WHERE {attribute} = {value}'
            cursor.execute(qry)
            conn.commit()
            return cursor.rowcount


def get_all(table, order_col='id', order='DESC'):
    with DAOHelper() as conn:
        with conn.cursor() as cursor:
            if order in ('DESC', 'ASC'):
                qry = f"SELECT * FROM {table} ORDER BY {order_col} {order}"
                cursor.execute(qry)
                return cursor.fetchall()
            else:
                return None


if __name__ == '__main__':
    print(f'Don\'t do this')
