from dataclasses import dataclass
from typing import List

from pydantic import BaseModel

from classes.persona import Persona


# Definir una classe Docent que hereti de Persona i afegeixi el camp centre_educatiu per indicar on treballa
@dataclass
class Docent(Persona, BaseModel):
    centre_educatiu: str


db: List[Docent] = []
