import os
import re
import sys
from pprint import pprint

import inquirer
from inquirer import errors

sys.path.append(os.path.realpath('.'))


def phone_validation(respostes, valor_actual):
    if not re.match('\+?\d[\d ]+\d', valor_actual):
        raise errors.ValidationError('', reason='No m\'agrada el teu número de telèfon!')

    return True


def run():
    preguntes = [
        inquirer.Text('nom',
                      message="Introdueix el teu nom"),
        inquirer.Text('cognoms',
                      message="Introdueix els teus cognoms, {nom}?"),
        inquirer.Text('telefon',
                      message="Introdueix el teu número de telèfon?",
                      validate=phone_validation,
                      )
    ]

    respostes = inquirer.prompt(preguntes)

    pprint(respostes)
