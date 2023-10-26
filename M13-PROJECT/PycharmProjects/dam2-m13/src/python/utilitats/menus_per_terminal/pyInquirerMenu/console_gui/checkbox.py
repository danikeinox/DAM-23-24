import os
import sys
import inquirer
from pprint import pprint
sys.path.append(os.path.realpath('.'))


def run():
    preguntes = [
        inquirer.Checkbox('interessos',
                          message="Quins són els teus interessos?",
                          choices=[
                              ('Informàtica', 'i'),
                              ('Lectura', 'l'),
                              ('Ciència', 'c'),
                              ('Natura', 'n'),
                              ('Astronomia', 'a'),
                              ('Historia', 'h'),
                          ],
                          default=['i', 'c']),
    ]

    respostes = inquirer.prompt(preguntes)

    pprint(respostes)
