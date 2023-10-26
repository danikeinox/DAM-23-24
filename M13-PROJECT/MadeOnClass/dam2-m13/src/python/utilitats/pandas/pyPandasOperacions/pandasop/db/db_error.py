import enum
import logging


class DBErrorCode(enum.Enum):
    NOT_CONNECTED = 100


class DBError(Exception):
    def __init__(self, exc_info, code=DBErrorCode.NOT_CONNECTED, message='ERROR'):
        self._code = code
        self._message = message
        if exc_info is not None:
            logging.info(f'{self.__class__}: {exc_info[1]}')
        else:
            logging.info(f'{self.__class__}: [{self._code}] - {self._message}')

    @property
    def code(self):
        return self._code

    @code.setter
    def code(self, code):
        self._code = code

    @property
    def message(self):
        return self._message

    @message.setter
    def message(self, message):
        self._message = message
