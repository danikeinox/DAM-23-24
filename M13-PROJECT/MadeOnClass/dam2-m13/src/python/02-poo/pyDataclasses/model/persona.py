from dataclasses import dataclass

from model.domicili import Domicili


# podem fer referència als mètodes a crear automàticament (True o False)
@dataclass(eq=True, frozen=True)
class Persona:
    id_persona: int
    nom: str
    cognoms: str
    domicili: Domicili
    data_naixement: str
    login: str
    passwd: str

    # def __init__(self): --> Es crea automàticament
    # def __repr__(self): --> Es crea automàticament
    # def __eq__(self, other): --> Es crea automàticament
    def __post_init__(self):  # Per si necessitem validar alguna dada
        if len(self.passwd) < 3:
            raise ValueError('Longitud de contrasenya errònia')
