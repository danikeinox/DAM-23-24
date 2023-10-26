import inquirer
from inquirer.themes import GreenPassion


def run():
    q = [
        inquirer.Text('nom',
                      message='Quin es el teu nom?',
                      default='No tinc nom'),
        inquirer.List('jon',
                      message='T\'agrada el suc de llimona?' ,
                      choices=['si', 'no'],
                      default='no'),
        inquirer.Checkbox('llista_llenguatges',
                          message='Quins llenguatges coneixes?',
                          choices=['Java', 'Python', 'C', 'C++'],
                          default='Python'
                          )
    ]
    inquirer.prompt(q, theme=GreenPassion())
