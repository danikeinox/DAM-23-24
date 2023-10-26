from datetime import date

from hospitalapp import log_info
from hospitalapp.db.connection import Connection
from hospitalapp.model.doctor import Doctor

# Sentències SQL típiques d'un CRUD bàsic
_DELETE = "DELETE FROM doctor WHERE doctor_id = %s;"
_SELECT_ONE = "SELECT doctor_id, hospital_id, nom, cognoms, data_alta, salari FROM doctor WHERE doctor_id = %s;"
_SELECT_ALL = "SELECT doctor_id, hospital_id, nom, cognoms, data_alta, salari FROM doctor;"
_INSERT = "INSERT INTO doctor (hospital_id, nom, cognoms, data_alta, salari) VALUES (%s, %s, %s, %s, %s) RETURNING doctor_id;"
_UPDATE = "UPDATE doctor SET hospital_id = %s, nom = %s, cognoms = %s, data_alta = %s, salari = %s WHERE doctor_id = %s;"
_GET_HOSPITAL = "SELECT h.hospital_id, h.nom FROM hospital h INNER JOIN doctor d ON h.hospital_id = d.hospital_id WHERE d.doctor_id = %s;"


class DoctorDAO:
    @classmethod
    def add(cls, hospital_id: int, nom: str, cognoms: str, data_alta: date, salari: int):
        """
        Inserta un nou registre a la BBDD a la taula: doctor
        :param hospital_id: identificador de l'hospital
        :param nom: nom del doctor
        :param cognoms: cognoms del doctor
        :param data_alta: data d'alta a l'hospital
        :param salari: salari
        :return: un objecte de la classe Doctor
        """
        conn = Connection()
        try:
            cursor = conn.cursor()
            data = (hospital_id, nom, cognoms, data_alta, salari,)
            cursor.execute(_INSERT, data)
            conn.commit()
            doctor_id = cursor.fetchone()[0]
            if doctor_id is not None:
                return Doctor(doctor_id=doctor_id, hospital_id=hospital_id, nom=nom, cognoms=cognoms,
                              data_alta=data_alta,
                              salari=salari)
            else:
                return None
        except Exception as e:
            conn.rollback()
            log_info(e)
        finally:
            conn.close()

    @classmethod
    def get(cls, doctor_id: int):
        """
        Obte un objecte de la classe Doctor donat el seu identificador
        :param doctor_id: identificador del doctor
        :return: l'objecte de la classe doctor cercat o None si no existeix
        """
        conn = Connection()
        try:
            cursor = conn.cursor()
            data = (doctor_id,)
            cursor.execute(_SELECT_ONE, data)
            item = cursor.fetchone()
            if item is not None:
                return Doctor(doctor_id=doctor_id, hospital_id=item[1], nom=item[2], cognoms=item[3], data_alta=item[4],
                              salari=item[5])
            else:
                return None

        except Exception as e:
            conn.rollback()
            log_info(e)
        finally:
            conn.close()

    @classmethod
    def getall(cls):
        """
        Obté una llista d'objectes de tipus Doctor
        :return: la llista d'objectes Doctor
        """
        conn = Connection()
        try:
            cursor = conn.cursor()
            cursor.execute(_SELECT_ALL)
            rows = cursor.fetchall()
            if rows is not None:
                doctors = list()
                for doctor in rows:
                    doctors.append(Doctor(doctor_id=doctor[0], hospital_id=doctor[1], nom=doctor[2], cognoms=doctor[3],
                                          data_alta=doctor[4], salari=doctor[5]))
                return doctors
            else:
                return None

        except Exception as e:
            conn.rollback()
            log_info(e)
        finally:
            conn.close()

    @classmethod
    def delete(cls, doctor_id: int) -> bool:
        """
        Elimina un registre de la taula doctor identificat pel seu identificador
        :param doctor_id: identificador del
        :return: True si s'ha eliminat. False en qualsevol altre cas
        """
        conn = Connection()
        try:
            cursor = conn.cursor()
            data = (doctor_id,)
            cursor.execute(_DELETE, data)
            conn.commit()
            if cursor.rowcount > 0:
                return True
            else:
                return False
        except Exception as e:
            conn.rollback()
            log_info(e)
        finally:
            conn.close()

    @classmethod
    def update(cls, doctor_id: int, hospital_id: int, nom: str, cognoms: str, data_alta: date, salari: int):
        """
        Actualitza un registre de tipus Doctor donat el seu identificador
        :param doctor_id: identificador del doctor a modificar
        :param hospital_id: identificador de l'hospital assignat
        :param nom: nom del doctor
        :param cognoms: cognoms del doctor
        :param data_alta: data d'alta a l'hospital
        :param salari: salari
        :return: l'object de classe Doctor modificat
        """
        conn = Connection()
        try:
            cursor = conn.cursor()
            data = (hospital_id, nom, cognoms, data_alta, salari, doctor_id)
            cursor.execute(_UPDATE, data)
            conn.commit()
            if cursor.rowcount is not None:
                return Doctor(doctor_id=doctor_id, hospital_id=hospital_id, nom=nom, cognoms=cognoms,
                              data_alta=data_alta,
                              salari=salari)
            else:
                return None

        except Exception as e:
            conn.rollback()
            log_info(e)
        finally:
            conn.close()

    @classmethod
    def gethospital(cls, doctor_id: int):
        """
        Obté l'hospital on està assignat un Doctor
        :param doctor_id: identificador del doctor
        :return: hospital on treballa el doctor
        """
        conn = Connection()
        try:
            cursor = conn.cursor()
            data = (doctor_id,)
            cursor.execute(_GET_HOSPITAL, data)
            hospital = cursor.fetchone()
            if hospital is not None:
                from hospitalapp.model.hospital import Hospital
                return Hospital(hospital_id=hospital[0], nom=hospital[1])
            else:
                return None
        except Exception as e:
            conn.rollback()
            log_info(e)
        finally:
            conn.close()
