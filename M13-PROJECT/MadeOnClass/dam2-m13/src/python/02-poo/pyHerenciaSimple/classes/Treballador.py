from classes.Persona import Persona


class Treballador(Persona):
    def __init__(self, nom, cognoms, dni, sou):
        super().__init__(nom, cognoms, dni)
        self._sou = sou

    @property
    def sou(self):
        return self._sou

    @sou.setter
    def nom(self, sou):
        self._sou = sou

    def __str__(self):
        return f'{super().__str__()} Sou: {self.sou}'
