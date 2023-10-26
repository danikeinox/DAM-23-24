from dataclasses import dataclass


@dataclass(eq=True, frozen=True)
class Domicili:
    adreca: str
    codi_postal: str
    ciutat: str
