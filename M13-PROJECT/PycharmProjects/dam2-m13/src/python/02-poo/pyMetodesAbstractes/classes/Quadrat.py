from classes.FiguraGeometrica import FiguraGeometrica


class Quadrat(FiguraGeometrica):
    def calcula_area(self):
        return self.alt * self.ample

    def __str__(self):
        return f'Quadrat [{FiguraGeometrica.__str__(self)}] --> Àrea: {self.calcula_area()}'
