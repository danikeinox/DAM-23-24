"""
    abc --> Abstract Base Class
    necessari per crear mètodes abstractes amb el decorador @abstractmethod
"""
from abc import abstractmethod, ABC


class FiguraGeometrica(ABC):  # Definim la classe com Abstracta --> no pot ser instanciada
    def __init__(self, alt, ample):
        self._alt = alt
        self._ample = ample

    @property
    def alt(self):
        return self._alt

    @alt.setter
    def alt(self, alt):
        self._alt = alt

    @property
    def ample(self):
        return self._ample

    @ample.setter
    def ample(self, ample):
        self._ample = ample

    @abstractmethod
    def calcula_area(self):
        pass

    def __str__(self):
        return f'FiguraGeomètrica [Alt: {self._alt} Ample: {self._ample}]'
