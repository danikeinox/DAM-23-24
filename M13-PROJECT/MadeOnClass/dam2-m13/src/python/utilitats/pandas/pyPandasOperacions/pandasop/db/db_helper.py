import logging

import pandas as pd

from pandasop.db.connection import Connection


def exec_sql(sql: str) -> list:
    conn = None
    try:
        conn = Connection()
        cursor = conn.cursor()
        cursor.execute(sql)
        return cursor.fetchall()
    except Exception as e:
        print(e)
        logging.info(f'ERROR: {e}')
    finally:
        if conn:
            conn.close()


def get_dataframe(sql: str) -> pd.DataFrame:
    """
    A partir d'una consulta SQL obté un DataFrame(pandas) amb el valor i les columnes definides tal i com està a la taula
    :param sql: consulta sql
    :return: el dataframe
    """
    conn = None
    try:
        conn = Connection()
        cursor = conn.cursor()
        cursor.execute(sql)
        data = cursor.fetchall()
        cols = []
        for col in cursor.description:
            cols.append(col[0])
        df = pd.DataFrame(data=data, columns=cols)
        return df
    except Exception as e:
        print(e)
        logging.info(f'ERROR: {e}')
    finally:
        if conn:
            conn.close()
