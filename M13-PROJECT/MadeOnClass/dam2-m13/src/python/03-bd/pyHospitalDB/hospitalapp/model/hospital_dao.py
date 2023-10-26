from dataclasses import dataclass

from hospitalapp import log_info
from hospitalapp.db.connection import Connection

_DELETE = "DELETE FROM hospital WHERE hospital_id = %s;"
_SELECT_ONE = "SELECT hospital_id, nom FROM hospital WHERE hospital_id = %s;"
_SELECT_ALL = "SELECT hospital_id, nom FROM hospital;"
_INSERT = "INSERT INTO hospital (nom) VALUES (%s) RETURNING hospital_id;"
_UPDATE = "UPDATE hospital SET nom = %s WHERE hospital_id = %s;"
_GET_DOC = "SELECT d.doctor_id, d.hospital_id, d.nom, d.cognoms, d.data_alta, d.salari FROM hospital h INNER JOIN doctor d ON h.hospital_id = d.hospital_id WHERE h.hospital_id = %s;"


# _GET_DOC = "SELECT d.doctor_id, d.hospital_id, d.nom, d.cognoms, d.data_alta, d.salari FROM hospital h, doctor d WHERE h.hospital_id = d.hospital_id AND h.hospital_id = %s;"


@dataclass
class HospitalDAO:
    @classmethod
    def add(cls, nom: str):
        """
        Insereix un nou registre a la taula hospital
        :param nom: nom de l'hospital
        :return: un objecte de la classe Hospital o None
        """
        conn = Connection()
        try:
            cursor = conn.cursor()
            data = (nom,)
            cursor.execute(_INSERT, data)
            conn.commit()
            hospital_id = cursor.fetchone()[0]
            if hospital_id is not None:
                return cls(hospital_id=hospital_id, nom=nom)
            else:
                return None
        except Exception as e:
            conn.rollback()
            log_info(e)
        finally:
            conn.close()

    @classmethod
    def get(cls, hospital_id: int):
        """
        Obté un objecte de la classe Hospital donat el seu identificador
        :param hospital_id: identificadot de l'hospital
        :return: objecte de la classe Hospital o None
        """
        conn = Connection()
        try:
            cursor = conn.cursor()
            data = (hospital_id,)
            cursor.execute(_SELECT_ONE, data)
            item = cursor.fetchone()
            if item is not None:
                return cls(hospital_id=hospital_id, nom=item[1])
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
        Obté una llista de tots els hospitals de la taua
        :return: llista dels hospitals o None
        """
        conn = Connection()
        try:
            cursor = conn.cursor()
            cursor.execute(_SELECT_ALL)
            rows = cursor.fetchall()
            if rows is not None:
                hospitals = list()
                for hospital in rows:
                    hospitals.append(cls(hospital_id=hospital[1], nom=hospital[2]))
                return hospitals
            else:
                return None

        except Exception as e:
            conn.rollback()
            log_info(e)
        finally:
            conn.close()

    @classmethod
    def delete(cls, hospital_id: int) -> bool:
        """
        Elimina un registre de la taula hospital donat el seu identificador
        :param hospital_id: identificador de l'hospital
        :return: True si s'ha elimin at correctament. False en qualsevol altre cas
        """
        conn = Connection()
        try:
            cursor = conn.cursor()
            data = (hospital_id,)
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
    def update(cls, hospital_id: int, nom: str):
        """
        Actuatliza un registre d'un hospital donat el seu identificador
        :param hospital_id: idetificador de l'hospital
        :param nom: nom de l'hospital
        :return: objecte modificat de la classe hospital
        """
        conn = Connection()
        try:
            cursor = conn.cursor()
            data = (nom, hospital_id,)
            cursor.execute(_UPDATE, data)
            conn.commit()
            if cursor.rowcount is not None:
                return cls(hospital_id=hospital_id, nom=nom)
            else:
                return None

        except Exception as e:
            conn.rollback()
            log_info(e)
        finally:
            conn.close()

    @classmethod
    def getdoctors(cls, hospital_id: int):
        """
        Obté una llista dels doctors que treballen a un hospital
        donat l'identficador de l'hospital
        :param hospital_id: identificador de l'hospital
        :return: llista amb els doctor assignats a l'identificador proporcionat
        """
        conn = Connection()
        try:
            cursor = conn.cursor()
            data = (hospital_id,)
            cursor.execute(_GET_DOC, data)
            rows = cursor.fetchall()
            if rows is not None:
                doctors = list()
                for doctor in rows:
                    from hospitalapp.model.doctor import Doctor
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
