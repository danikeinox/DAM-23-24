from utils.logger_base import log
from model.persona import Persona
from bd.pool_cursor import PoolCursor


# Classe que actua de mapa entre el model E-R i el OO (Data Access Objects)
class PersonaDAO:
    _SELECT = 'SELECT * FROM tbl_persona ORDER BY id'
    _INSERT = 'INSERT INTO tbl_persona(nom, cognoms, adreca, codi_postal, ciutat, data_naixement, login, passwd) ' \
              'VALUES(?, ?, ?, ?, ?, ?, ?, ?)'
    _UPDATE = 'UPDATE tbl_persona SET nom = ?, cognoms = ?, adreca = ?, codi_postal = ?, ciutat = ?, ' \
              'data_naixement = ?, login = ?, passwd = ? WHERE id=?'
    _DELETE = 'DELETE FROM tbl_persona WHERE id=?'

    @classmethod
    def select(cls):
        with PoolCursor() as cursor:
            cursor.execute(cls._SELECT)
            registres = cursor.fetchall()
            persones = []
            for reg in registres:
                p = Persona(reg[0], reg[1], reg[2], reg[3], reg[4], reg[5], reg[6], reg[7], reg[8])
                persones.append(p)
            return persones

    @classmethod
    def insert(cls, person, last=True):
        with PoolCursor() as cursor:
            valors = (
                person.nom, person.cognoms, person.adreca,
                person.codi_postal, person.ciutat, person.data_naixement,
                person.login, person.passwd)
            cursor.execute(cls._INSERT, valors)
            log.debug(f'Persona inserida: {person}')
            return cursor.lastrowid if last else cursor.rowcount

    @classmethod
    def update(cls, person):
        with PoolCursor() as cursor:
            valors = (
                person.nom, person.cognoms, person.adreca,
                person.codi_postal, person.ciutat, person.data_naixement,
                person.login, person.passwd, person.id_persona)
            cursor.execute(cls._UPDATE, valors)
            log.debug(f'Persona actualitzada: {person}')
            return cursor.rowcount

    @classmethod
    def delete(cls, person):
        with PoolCursor() as cursor:
            # valors = (person.id_persona,)
            cursor.execute(cls._DELETE, (person.id_persona,))
            log.debug(f'Persona eliminada: {person}')
            return cursor.rowcount


if __name__ == '__main__':
    print("Dont do that!")
