from dataclasses import dataclass

from classes import Esdeveniment
from classes.GestorEsdeveniments import esdeveniments
from gestio_esdeveniments.esdeveniment.esdeveniment import Persona


@dataclass
class GestorEsdeveniments:
    def crear_esdeveniment(self, esdeveniment: Esdeveniment):
        esdeveniments.append(esdeveniment)
        return self

    def mostrar_esdeveniments(self):
        print(esdeveniments)
        return self

    def inscriure_persona(self, esdeveniment_idx: int, persona: Persona):
        esdeveniments[esdeveniment_idx].inscriure_persona(persona)
        return self

    def aplicar_descompte(self, persona: Persona):
        for esdeveniment in esdeveniments:
            esdeveniment.aplicar_descompte(persona)
        return self


