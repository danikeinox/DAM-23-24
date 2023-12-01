from dataclasses import dataclass

from conceptes.seccio import Seccio


@dataclass
class Treballador(object):
    nom: str
    sou: float
    seccio: Seccio
    alta_contracte: str

    def augmenta_sou(self, percentatge):
        self.sou += self.sou * percentatge / 100

    def __str__(self) -> str:
        return f'El nom és {self.nom}\nEl sou és {self.sou}\nLa secció és {self.seccio.value}\nLa data de contractació és {self.alta_contracte}'
