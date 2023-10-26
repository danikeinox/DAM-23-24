from classes.comandament_formal import ComandamentF


class ComandamentSony(ComandamentF):
    def canal_seguent(self):
        print(f'Classe {self.__class__} -- {self.__module__}')

    def canal_anterior(self):
        print(f'Classe {self.__class__} -- {self.__module__}')

    def pujar_volum(self):
        print(f'Classe {self.__class__} -- {self.__module__}')

    def baixa_volum(self):
        print(f'Classe {self.__class__} -- {self.__module__}')
