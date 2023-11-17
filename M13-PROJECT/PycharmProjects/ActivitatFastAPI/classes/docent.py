from dataclasses import dataclass

from pydantic import BaseModel

from classes import persona


# Definir una classe Docent que hereti de Persona i afegeixi el camp centre_educatiu per indicar on treballa
@dataclass
class Docent(persona):
    def __init__(self, id: int, name: str, email: str, edat: int, centre_educatiu: str):
        super().__init__(id, name, email, edat)
        self.centre_educatiu = centre_educatiu
