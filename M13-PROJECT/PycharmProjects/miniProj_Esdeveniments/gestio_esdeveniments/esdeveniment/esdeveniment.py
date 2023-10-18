from dataclasses import dataclass


@dataclass
class Persona:
    nom: str
    edat: int
    email: str

    def __str__(self):
        return f"Nom: {self.nom} \nEdat: {self.edat} \nEmail: {self.email}"
