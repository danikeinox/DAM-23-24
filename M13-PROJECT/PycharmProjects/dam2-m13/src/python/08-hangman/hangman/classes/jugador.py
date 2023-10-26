class Jugador:
    def __init__(self, nickname):
        self.nickname = nickname
        self.intents = 0

    def incrementar_intents(self):
        self.intents += 1
