from dataclasses import dataclass


@dataclass
class Cesar:
    key: int
    value: str
    alphabet = "abcdefghijklmnopqrstuvwxyz"

    def encryptCesar(self):
        return self.value.translate(str.maketrans(self.alphabet, self.alphabet[self.key:] + self.alphabet[:self.key]))

    def decryptCesar(self):
        return self.value.translate(str.maketrans(self.alphabet[self.key:] + self.alphabet[:self.key], self.alphabet))
