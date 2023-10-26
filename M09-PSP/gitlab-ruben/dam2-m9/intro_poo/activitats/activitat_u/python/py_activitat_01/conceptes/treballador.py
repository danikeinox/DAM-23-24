from datetime import datetime

from conceptes.seccio import Seccio


class Treballador(object):
    def __init__(self, nom, sou, seccio=Seccio.ADMINISTRACIO, alta_contracte=datetime.today().strftime('%d/%m/%Y')):
        """
            Mètode constructor de la classe
        :param nom: Nom del treballador
        :param sou: Sou del treballador
        :param seccio: Secció on pertany el traballador
        :param alta_contracte: Data d'alta a l'empresa
        """
        self._nom = nom
        self._sou = sou
        self._seccio = seccio
        self._alta_contracte = alta_contracte

    @property
    def nom(self):
        return self._nom

    @nom.setter
    def nom(self, nom):
        self._nom = nom

    @property
    def sou(self):
        return self._sou

    @sou.setter
    def sou(self, sou):
        self._sou = sou

    @property
    def seccio(self):
        return self._seccio

    @seccio.setter
    def seccio(self, seccio):
        self._seccio = seccio

    @property
    def alta_contracte(self):
        return self._alta_contracte

    @alta_contracte.setter
    def alta_contracte(self, alta_contracte):
        self._alta_contracte = alta_contracte

    def augmenta_sou(self, percentatge):
        self._sou += self._sou * percentatge / 100

    def __str__(self) -> str:
        return f'El nom és {self.nom}\nEl sou és {self.sou}\nLa secció és {self.seccio.value}\nLa data de contractació és {self.alta_contracte}'
