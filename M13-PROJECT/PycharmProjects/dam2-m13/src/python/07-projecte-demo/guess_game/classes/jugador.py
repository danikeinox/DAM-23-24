class Jugador:
    def __init__(self, nickname):
        self.nickname = nickname
        self.encerts = 0

    def incrementar_encerts(self):
        self.encerts += 1
