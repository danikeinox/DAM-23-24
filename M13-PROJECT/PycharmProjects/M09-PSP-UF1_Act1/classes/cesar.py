from dataclasses import dataclass


def alphabet():
    return "abcdefghijklmnopqrstuvwxyz"


@dataclass
class Cesar:
    key: int
    value: str

    def encryptCesar(self):
        return self.value.translate(str.maketrans(alphabet(), alphabet()[self.key:] + alphabet()[:self.key]))

    def decryptCesar(self):
        return self.value.translate(str.maketrans(alphabet()[self.key:] + alphabet()[:self.key], alphabet()))