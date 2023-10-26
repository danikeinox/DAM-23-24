from abc import ABC, abstractmethod


class ComandamentF(ABC):
    @abstractmethod
    def canal_seguent(self):
        pass

    @abstractmethod
    def canal_anterior(self):
        pass

    @abstractmethod
    def pujar_volum(self):
        pass

    @abstractmethod
    def baixa_volum(self):
        pass
