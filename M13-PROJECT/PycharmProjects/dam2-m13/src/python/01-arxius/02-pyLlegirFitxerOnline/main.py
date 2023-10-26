# Llegir contingut en línia
import shutil
import tempfile
from urllib.request import urlopen

_URL = 'http://m15.ies-eugeni.cat/m15_python_online_text.txt'


def llegir_fitxer_online(url):
    with urlopen(url) as missatge:
        # contingut = missatge.read()
        contingut = missatge.read().decode('utf-8')
        print(contingut)

    with open('nou_fitxer.txt', 'w', encoding='utf-8') as fitxer:
        fitxer.write(contingut)


# LLegim el fitxer i el treballem a un recurs temporal
def llegir_fitxer_online_a_tmp(url):
    with urlopen(url) as resposta:
        with tempfile.NamedTemporaryFile(delete=False) as tmp_file:
            shutil.copyfileobj(resposta, tmp_file)

    with open(tmp_file.name) as fitxer:
        contingut = fitxer.read()
        print(contingut)


def llegir_paraules_online(url):
    paraules = []
    with urlopen(url) as missatge:
        for linia in missatge:
            paraules_per_linia = linia.decode('utf-8').split()
            for paraula in paraules_per_linia:
                paraules.append(paraula)
    print(paraules)


def run_main():
    # llegir_fitxer_online(_URL)
    llegir_fitxer_online_a_tmp(_URL)
    # llegir_paraules_online(_URL)


if __name__ == '__main__':
    run_main()
