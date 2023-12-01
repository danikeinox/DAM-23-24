from conceptes.treballador import Treballador


class Cap(Treballador):
    def __init__(self, nom, sou, incentiu):
        self._incentiu = incentiu
        super().__init__(nom, sou)

    @property
    def incentiu(self):
        return self._incentiu

    @incentiu.setter
    def incentiu(self, incentiu):
        self._incentiu = incentiu

    @property
    def sou(self):
        return super().sou + self.incentiu

    def __str__(self) -> str:
        return super().__str__() + f'\nIncentiu {self.incentiu}'
