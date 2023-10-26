# -*- coding: utf-8 -*-

# + info: https://github.com/kennethreitz/setup.py
#         https://stackoverflow.com/questions/1471994/what-is-setup-py


from setuptools import setup, find_packages

with open('README.md') as f:
    readme = f.read()

with open('LICENSE') as f:
    lic = f.read()

setup(
    name='exemple',
    version='0.0.1',
    description='Paquet d\'exemple',
    long_description=readme,
    author='Rubén Nadal',
    author_email='rnadal27@xtec.cat',
    url='https://gitlab.com/rnadalb/dam2-m13/-/tree/main/src/python/06-estructura-projecte',
    license=lic,
    packages=find_packages(exclude=('tests', 'docs'))
)
