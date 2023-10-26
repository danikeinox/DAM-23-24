import os
import sys
import inquirer
from pprint import pprint
sys.path.append(os.path.realpath('.'))

def run():
    preguntes = [
        inquirer.List('grandaria',
                      message="Com vols la teva hamburguesa?",
                      choices=['XXL', 'XL', 'L', 'M', 'S', 'Demana un vegetal'],
                  ),
    ]

    respostes = inquirer.prompt(preguntes)

    pprint(respostes)