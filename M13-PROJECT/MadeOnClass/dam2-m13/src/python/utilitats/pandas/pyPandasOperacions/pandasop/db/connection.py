import os
import sys

import psycopg
from psycopg import OperationalError

from pandasop.db.db_error import DBError, DBErrorCode


class Connection(object):
    def __init__(self):
        """
        Constructor de la classe
        ALERTA: Agafa tots els paràmetres de connexió de variables d'entorn del sistema operatiu
        """
        self._host = None
        self._port = None
        self._user = None
        self._dbname = None
        self._password = None
        self._sslmode = None
        self._conn = None
        try:
            # Obtenim les dades de connexió des de les variables d'entorn del SO
            self._host = os.environ['POSTGRES_HOST']
            self._port = os.environ['POSTGRES_PORT']
            self._user = os.environ['POSTGRES_USER']
            self._dbname = os.environ['POSTGRES_DBNAME']
            self._password = os.environ['POSTGRES_PASSWORD']
            self._sslmode = os.environ['POSTGRES_SSLMODE']  # disable, allow, prefer, require, verify-ca, verify-full

            # Construeix la connection string
            conn_string = f"host={self.host} port={self.port} user={self.user} dbname={self.dbname} password={self.password} sslmode={self.sslmode}"

            self._conn = psycopg.connect(conn_string)
            print("Connection.__init__ Connexió establerta")
        except OperationalError:
            raise DBError(sys.exc_info(), code=DBErrorCode.NOT_CONNECTED,
                          message="Error. No es possible connectar a la base de dades")

    def close(self):
        """
        Tanca la connexió a la base de dades
        :return:
        """
        try:
            if self.conn:
                self.conn.close()
            print("Connection.close() Connexió tancada")
        except OperationalError:
            raise DBError(sys.exc_info(), code=DBErrorCode.NOT_CONNECTED,
                          message="Error. No es possible connectar a la base de dades")

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
