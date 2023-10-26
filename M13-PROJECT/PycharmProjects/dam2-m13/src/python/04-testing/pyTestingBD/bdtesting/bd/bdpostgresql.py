import sys
import psycopg2 as bd
from bdtesting.utils.logger_base import log


class BDPostgreSQL:
    _HOST = 'X-->ask<--X'
    _USER = 'X-->ask<--X'
    _PASSWORD = 'X-->ask<--X'
    _DATABASE = 'X-->ask<--X'
    _PORT = 5432
    __conn = None

    # Utilitzem decoradors per indicar que és un mètode de classe
    @classmethod
    def get_connection(cls):
        try:
            cls.__conn = bd.connect(
                host=cls._HOST,
                user=cls._USER,
                password=cls._PASSWORD,
                port=cls._PORT,
                database=cls._DATABASE
            )
            log.debug(f'Connexió exitosa id [{cls.__conn.info.status}]')
            return cls.__conn
        except Exception as e:
            log.error(f'Error al obtenir la connexió: {e}')
            log.error(f'Connexió errònia codi [{cls.__conn.info.status}]')
            sys.exit()

    def __exit__(self, exc_type, exc_val, exc_tb):
        print("Connexió tancada")
        self.__conn.close()


if __name__ == '__main__':
    con = BDPostgreSQL.get_connection()
    
