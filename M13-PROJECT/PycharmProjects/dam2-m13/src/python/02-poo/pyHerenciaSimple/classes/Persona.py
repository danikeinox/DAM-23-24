class Persona:
    def __init__(self, nom, cognoms, dni):
        self._nom = nom
        self._cognoms = cognoms
        self._dni = dni

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
    def dni(self):
        return self._dni

    @dni.setter
    def dni(self, dni):
        self._dni = dni

    def __str__(self) -> str:
        return f'Nom: {self._nom} Cognoms: {self._cognoms}'
