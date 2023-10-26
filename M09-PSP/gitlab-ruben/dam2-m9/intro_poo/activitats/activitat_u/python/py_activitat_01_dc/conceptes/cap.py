from dataclasses import dataclass

from conceptes.treballador import Treballador


@dataclass
class Cap(Treballador):
    incentiu: float

    def __str__(self) -> str:
        return super().__str__() + f'\nIncentiu {self.incentiu}'
