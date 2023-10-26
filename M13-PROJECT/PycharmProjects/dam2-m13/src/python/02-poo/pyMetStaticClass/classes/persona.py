from datetime import date


class Persona:
    def __init__(self, nom, cognoms, any_naixement):
        self._nom = nom
        self._cognoms = cognoms
        self._any_naixement = any_naixement

    @staticmethod
    def from_edat_pare(nom, cognoms, any_naixement_pare, diferencia_edat):
        return Persona(nom, cognoms, (date.today().year - any_naixement_pare - diferencia_edat))

    @classmethod
    def from_nom_complet(cls, nom_complet, any_naixement):
        nom, cognoms = map(str, nom_complet.split(' ', maxsplit=1))
        return cls(nom, cognoms, any_naixement)

    @property
    def nom(self):
        return self._nom

    @nom.setter
    def nom(self, nom):
        self._nom = nom

    @property
    def cognoms(self):
        return self._cognoms

    @cognoms.setter
    def cognoms(self, cognoms):
        self._cognoms = cognoms

    @property
    def any_naixement(self):
        return self._any_naixement

    @any_naixement.setter
    def any_naixement(self, any_naixement):
        self._any_naixement = any_naixement

    def __str__(self) -> str:
        return f'Nom: {self.nom} {self.cognoms}\nEdat: {date.today().year - self.any_naixement}'  # Alerta a la sortida
