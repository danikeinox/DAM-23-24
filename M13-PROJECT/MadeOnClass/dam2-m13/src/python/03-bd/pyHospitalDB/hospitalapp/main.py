import datetime

from hospitalapp.model.doctor_dao import DoctorDAO
from hospitalapp.db.util import importdb
from hospitalapp.model.hospital_dao import HospitalDAO


def main():
    importdb("../database.sql")
    # C -> create
    doctor = DoctorDAO.add(hospital_id=1, nom="Paco", cognoms="Lucía", data_alta=datetime.date(2022, 5, 28), salari=50000)
    print(doctor)
    # R -> read
    doctor = DoctorDAO.get(1)
    print(doctor)
    # U -> update
    print(f"Valor antic {doctor}")
    doctor = DoctorDAO.update(doctor_id=1,
                           hospital_id=doctor.hospital_id,
                           nom="Rubén",
                           cognoms="Nadal",
                           data_alta=doctor.data_alta,
                           salari=doctor.salari * 0.5)
    print(f"Desprès d'actualtizar {doctor}")
    # D -> delete
    if DoctorDAO.delete(2):
        print("Registre eliminat correctament")
    # Llistat de tots els doctors
    print(DoctorDAO.getall())
    # Obtenir els doctors d'un hospital id: 1
    print(HospitalDAO.getdoctors(1))
    # Obtenir l'hospital on treballa el doctor amb id 1
    print(DoctorDAO.gethospital(1))


if __name__ == '__main__':
    main()
