from dataclasses import dataclass

from gestio_esdeveniments.persones.persona import Persona

@dataclass
class Estudiant(Persona):
    estudis: str

    def __str__(self):
        return f"{super().__str__()} \nEstudis: {self.estudis}"
