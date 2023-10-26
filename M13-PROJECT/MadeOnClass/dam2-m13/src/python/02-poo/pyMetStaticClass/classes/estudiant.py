from classes.persona import Persona


class Estudiant(Persona):
    def __str__(self):
        return super().__str__() + f' en edat escolar ;-)\n'
