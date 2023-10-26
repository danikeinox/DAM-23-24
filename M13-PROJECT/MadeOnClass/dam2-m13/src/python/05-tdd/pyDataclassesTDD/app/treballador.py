from dataclasses import dataclass


@dataclass
class Treballador:
    """Representació bàsica d'un treballador/a"""

    nom: str
    id_treballador: int
    ratio_nomina: float = 100.0
    hores_dedicacio: float = 0.0
    nomina: float = 1000.0
    comissio: float = 100.0
    contractes_tancats: int = 0

    @property
    def te_comissio(self) -> bool:
        """Comprovem si el treballdor/a te comissió."""
        return self.comissio > 0

    def calcula_sou(self) -> float:
        """Calculem que ha de cobrar el treballador/a."""
        sou = self.ratio_nomina * self.hores_dedicacio + self.nomina
        if self.te_comissio:
            sou += self.comissio * self.contractes_tancats
        return sou
