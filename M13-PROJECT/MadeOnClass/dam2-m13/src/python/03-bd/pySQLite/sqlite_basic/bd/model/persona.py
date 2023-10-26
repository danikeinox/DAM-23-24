from dataclasses import dataclass


@dataclass
class Persona(object):
    id: int
    nom: str
    cognoms: str
    edat: int
    email: str
