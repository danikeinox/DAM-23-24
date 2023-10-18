from dataclasses import dataclass

from gestio_esdeveniments.persones.persona import Persona

@dataclass
class Treballador(Persona):
    ocupacio: str

    def __str__(self):
        return f"{super().__str__()} \nOcupacio: {self.ocupacio}"
