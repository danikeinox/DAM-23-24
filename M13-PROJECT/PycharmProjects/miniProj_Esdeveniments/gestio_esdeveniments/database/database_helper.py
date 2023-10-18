import os
import psycopg2-binary


class DatabaseHelper:
    def __init__(self):
        try:
            self._host = os.environ["DB_HOST"]
            self._port = os.environ["DB_PORT"]
            self._user = os.environ["DB_USER"]
            self._password = os.environ["DB_PASSWORD"]
            self._database = os.environ["DB_DATABASE"]
            self._sslmode = os.environ["DB_SSLMODE"]

            conn_string = f"host={self._host} port={self._port} user={self._user} password={self._password} dbname={self._database} sslmode={self._sslmode}"

            self._conn = psycopg2.connect(conn_string)
            self._cursor = self.conn.cursor()
        except Exception as e:
            print(e)

    def __enter__(self):
        return self

    def __exit__(self, exc_type, exc_val, exc_tb):
        self.close()

    def close(self):
        self._conn.close()

    def execute(self, sql: str, params=None):


    @property
    def connection(self):
        return self._conn

    @property
    def cursor(self):
        return self._cursor
