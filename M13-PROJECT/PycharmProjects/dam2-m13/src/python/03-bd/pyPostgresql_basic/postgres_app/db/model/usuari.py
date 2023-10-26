from dataclasses import dataclass
from datetime import datetime


@dataclass
class Usuari(object):
    id_usuari: int
    email: str
    password: str
    nom: str
    cognoms: str
    alta: datetime
    bloquejat: bool = False

    @staticmethod
    def to_usuari(record: tuple):
        usuaris = list()
        for r in record:
            u = Usuari(id_usuari=r[0],
                       email=r[1],
                       password=r[2],
                       nom=r[3],
                       cognoms=r[4],
                       bloquejat=r[5],
                       alta=r[6])
            usuaris.append(u)
        return usuaris
