import os
import sys
import inquirer
from pprint import pprint
sys.path.append(os.path.realpath('.'))


def run():
    preguntes = [
        inquirer.Confirm('continuar',
                         message="Hauria de continuar?"),
        inquirer.Confirm('stop',
                         message="Hauria de parar?", default=True),
    ]

    respostes = inquirer.prompt(preguntes)

    pprint(respostes)
