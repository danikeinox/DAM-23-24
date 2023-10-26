import mariadb

import config


class DAOHelper:
    def __init__(self, user=config.user, password=config.password, host=config.host, database=config.database,
                 port=config.port, ignore_error=False):
        self.user = user
        self.password = password
        self.host = host
        self.database = database
        self.port = port
        self.ignore_error = ignore_error

    def __enter__(self):
        self.connection = mariadb.connect(user=self.user,
                                          password=self.password,
                                          host=self.host,
                                          port=self.port,
                                          database=self.database)
        return self.connection

    def __exit__(self, ex_type, ex_value, traceback):
        self.connection.close()
        if ex_type is not None:
            return self.ignore_error
