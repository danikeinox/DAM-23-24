"""
    Els gestors de context permeten estalviar codi, eliminant tot allò repetitiu
"""


class ResourceManager:
    def __init__(self, file_name, method, encoding='utf8'):
        self.file = open(file_name, method, encoding=encoding)

    def __enter__(self):
        return self.file

    def __exit__(self, exception_type, execption_value, traceback):
        if self.file:
            self.file.close()
