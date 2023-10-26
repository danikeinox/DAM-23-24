import os
import sys

import psycopg2
from psycopg2 import OperationalError

from hospitalapp.db.db_error import DBError, DBErrorCode


class Connection(object):
    def __init__(self):
        """
        Constructor de la classe
        ALERTA: Agafa tots els paràmetres de connexió de variables d'entorn del sistema operatiu
        """
        try:
            # Obtenim les dades de connexió des de les variables d'entorn del SO
            self._host = os.environ['PSQL_HOST']
            self._port = os.environ['PSQL_PORT']
            self._user = os.environ['PSQL_USER']
            self._dbname = os.environ['PSQL_DBNAME']
            self._password = os.environ['PSQL_PASSWORD']
            self._sslmode = os.environ['PSQL_SSLMODE']  # disable, allow, prefer, require, verify-ca, verify-full

            # Construeix la connection string
            conn_string = f"host={self.host} port={self.port} user={self.user} " \
                          f"dbname={self.dbname} password={self.password} " \
                          f"sslmode={self.sslmode}"

            self._conn = psycopg2.connect(conn_string)
        except OperationalError:
            raise DBError(sys.exc_info(), code=DBErrorCode.NOT_CONNECTED,
                          message="Error. No es possible connectar a la base de dades")

    def close(self):
        """
        Tanca la connexió a la base de dades
        """
        try:
            if self.conn:
                self.conn.close()
        except OperationalError:
            raise DBError(sys.exc_info(), code=DBErrorCode.NOT_CONNECTED,
                          message="Error. No es possible connectar a la base de dades")

    def commit(self):
        self.conn.commit()

    def rollback(self):
        self.conn.rollback()

    def cursor(self):
        return self.conn.cursor()

    @property
    def host(self):
        return self._host

    @property
    def port(self):
        return self._port

    @property
    def user(self):
        return self._user

    @property
    def dbname(self):
        return self._dbname

    @property
    def password(self):
        return self._password

    @property
    def sslmode(self):
        return self._sslmode

    @property
    def conn(self):
        return self._conn
