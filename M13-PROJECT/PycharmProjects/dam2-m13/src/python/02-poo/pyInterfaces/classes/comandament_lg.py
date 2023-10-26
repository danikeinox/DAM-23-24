from classes.comandament_informal import ComandamentI


class ComandamentLG(ComandamentI):
    def canal_seguent(self):
        super().canal_seguent()
        print(f'Classe {self.__class__} -- {self.__module__}')

    def canal_anterior(self):
        super().canal_anterior()
        print(f'Classe {self.__class__} -- {self.__module__}')

    def pujar_volum(self):
        super().pujar_volum()
        print(f'Classe {self.__class__} -- {self.__module__}')

    def baixa_volum(self):
        super().baixa_volum()
        print(f'Classe {self.__class__} -- {self.__module__}')
