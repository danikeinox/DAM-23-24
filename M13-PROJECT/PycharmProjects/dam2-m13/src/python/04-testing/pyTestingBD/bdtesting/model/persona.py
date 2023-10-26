# Classe bàsica que representa una persona
class Persona:
    def __init__(self, nom, cognoms, adreca, codi_postal, ciutat, data_naixement, login, passwd, id_persona=None):
        self._id_persona = id_persona
        self._nom = nom
        self._cognoms = cognoms
        self._adreca = adreca
        self._codi_postal = codi_postal
        self._ciutat = ciutat
        self._data_naixement = data_naixement
        self._login = login
        self._passwd = passwd

    @classmethod
    def from_record(cls, record):
        return cls(record[1],
                   record[2],
                   record[3],
                   record[4],
                   record[5],
                   record[6],
                   record[7],
                   record[8],
                   record[0])

    def __eq__(self, persona):
        # Cal convertir a str (timestamp -> str)
        return (self._id_persona == persona._id_persona) and \
               (self._nom == persona._nom) and \
               (self._cognoms == persona._cognoms) and \
               (self._adreca == persona._adreca) and \
               (self._codi_postal == persona._codi_postal) and \
               (self._ciutat == persona._ciutat) and \
               (str(self._data_naixement) == str(persona._data_naixement)) and \
               (self._login == persona._login) and \
               (self._passwd == persona._passwd)

    def __str__(self):
        return f"{self._id_persona} - {self._cognoms}, {self._nom}"

    @property
    def id_persona(self):
        return self._id_persona

    @id_persona.setter
    def id_persona(self, id_persona):
        self._id_persona = id_persona

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
    def adreca(self):
        return self._adreca

    @adreca.setter
    def adreca(self, adreca):
        self._adreca = adreca

    @property
    def codi_postal(self):
        return self._codi_postal

    @codi_postal.setter
    def codi_postal(self, codi_postal):
        self._codi_postal = codi_postal

    @property
    def ciutat(self):
        return self._ciutat

    @ciutat.setter
    def ciutat(self, ciutat):
        self._ciutat = ciutat

    @property
    def data_naixement(self):
        return self._data_naixement

    @data_naixement.setter
    def data_naixement(self, data_naixement):
        self._data_naixement = data_naixement

    @property
    def login(self):
        return self._login

    @login.setter
    def login(self, login):
        self._login = login

    @property
    def passwd(self):
        return self._passwd

    @passwd.setter
    def passwd(self, passwd):
        self._passwd = passwd
