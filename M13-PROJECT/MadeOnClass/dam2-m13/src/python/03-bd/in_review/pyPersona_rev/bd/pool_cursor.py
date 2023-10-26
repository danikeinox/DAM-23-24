from bd.connexio import Connexio
from utils.logger_base import log


# Classe que gestiona un pool de connexions
class PoolCursor:
    def __init__(self):
        log.debug(f"PoolCursor.__init__")
        self._connexio = None
        self._cursor = None

    def __enter__(self):
        log.debug(f'PoolCursor.__enter__')
        self._connexio = Connexio.get_connection()
        self._cursor = self._connexio.cursor()
        return self._cursor

    def __exit__(self, exc_type, exc_val, exc_tb):
        log.debug(f'PoolCursor.__exit__')
        if exc_val:
            self._connexio.rollback()
            log.debug(f"Ha ocorregut un error {exc_val}")
        else:
            self._connexio.commit()
        self._cursor.close()
        Connexio.free_connection(self._connexio)
