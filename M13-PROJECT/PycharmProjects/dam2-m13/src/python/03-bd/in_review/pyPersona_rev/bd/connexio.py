import sys

import mariadb as bd

from utils.logger_base import log


class Connexio:
    _HOST = 'X->ask<-X'
    _USER = 'X->ask<-X'
    _PASSWORD = 'X->ask<-X'
    _DATABASE = 'X->ask<-X'
    _PORT = 3306
    _POOL_SIZE = 5
    _pool = None

    # Utilitzem decoradors per indicar que és un mètode de classe
    @classmethod
    def create_connection_pool(cls):
        if cls._pool is None:
            try:
                cls._pool = bd.ConnectionPool(
                    host=cls._HOST,
                    user=cls._USER,
                    password=cls._PASSWORD,
                    port=cls._PORT,
                    database=cls._DATABASE,
                    pool_name='cpool',
                    pool_size=cls._POOL_SIZE)
                log.debug(f'Connexió exitosa: {cls._pool}')
                return cls._pool
            except Exception as e:
                log.error(f'Error al obtenir el pool: {e}')
                sys.exit()
        else:
            return cls._pool

    # Obté una nova connexió del pool de connexions
    @classmethod
    def get_connection(cls):
        conn = cls.create_connection_pool().get_connection()
        log.debug(f"S'ha obtés una connexió del pool {conn}")
        return conn

    # Allibera els recursos de la connexió (torna la connexió al pool)
    @classmethod
    def free_connection(cls, conn):
        conn.close()
        log.debug(f"S'ha alliberat una connexió del pool {conn}")


if __name__ == '__main__':
    print("Don't do that !")
