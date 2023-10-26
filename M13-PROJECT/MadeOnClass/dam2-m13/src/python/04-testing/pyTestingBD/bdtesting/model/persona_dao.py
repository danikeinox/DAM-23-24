# Classe que actua de mapa entre el model E-R i el OO (Data Access Objects)
from bdtesting.bd.bdpostgresql import BDPostgreSQL


class PersonaDAO:
    _SELECT = 'SELECT * FROM tbl_persona ORDER BY id'
    _SELECT_ID = 'SELECT * FROM tbl_persona WHERE id = %s'
    _INSERT = 'INSERT INTO tbl_persona(nom, cognoms, adreca, codi_postal, ciutat, data_naixement, login, passwd) ' \
              'VALUES(%s, %s, %s, %s, %s, %s, %s, %s) RETURNING id'
    _UPDATE = 'UPDATE tbl_persona SET nom = %s, cognoms = %s, adreca = %s, codi_postal = %s, ciutat = %s, ' \
              'data_naixement = %s, login = %s, passwd = %s WHERE id = %s'
    _DELETE = 'DELETE FROM tbl_persona WHERE id = %s'

    @classmethod
    def select(cls):
        with BDPostgreSQL.get_connection() as conn:
            with conn.cursor() as c:
                c.execute(cls._SELECT)
                persones = c.fetchall()
        if len(persones) > 0:
            return persones
        else:
            return None

    @classmethod
    def select_by_id(cls, idpersona):
        with BDPostgreSQL.get_connection() as conn:
            with conn.cursor() as c:
                c.execute(cls._SELECT_ID, (idpersona,))
                persona = c.fetchone()
        if persona:
            return persona
        else:
            return None

    @classmethod
    def insert(cls, persona, last=True):
        with BDPostgreSQL.get_connection() as conn:
            with conn.cursor() as c:
                c.execute(cls._INSERT, (persona.nom,
                                        persona.cognoms,
                                        persona.adreca,
                                        persona.codi_postal,
                                        persona.ciutat,
                                        persona.data_naixement,
                                        persona.login,
                                        persona.passwd
                                        ))
                last_id = c.fetchone()[0]  # Obtè l'últim id inserit
        return last_id

    @classmethod
    def update(cls, person):
        with BDPostgreSQL.get_connection() as conn:
            with conn.cursor() as c:
                c.execute(cls._UPDATE, (person.nom,
                                        person.cognoms,
                                        person.adreca,
                                        person.codi_postal,
                                        person.ciutat,
                                        person.data_naixement,
                                        person.login,
                                        person.passwd,
                                        person.id_persona
                                        ))

    @classmethod
    def delete(cls, idpersona):
        with BDPostgreSQL.get_connection() as conn:
            with conn.cursor() as c:
                c.execute(cls._DELETE, (idpersona,))
            conn.commit()


if __name__ == '__main__':
    print("Dont do that!")
