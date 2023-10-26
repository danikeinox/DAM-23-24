from dataclasses import dataclass
from datetime import date

from hospitalapp import log_info
from hospitalapp.db.connection import Connection



@dataclass
class Doctor:
    """
    Classe que representa a un Doctor
    """
    doctor_id: int
    hospital_id: int
    nom: str
    cognoms: str
    data_alta: date
    salari: int
