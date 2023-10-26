all: clean build

req:
	pip install -r requirements.txt

build:
	pyinstaller --console --windowed --onefile hangman/__main__.py

dist:
	python setup.py sdist bdist_wheel bdist

clean:
	rm -rf build dist hangman.egg-info __pycache__ *.spec

help:
	@echo "Opcions de construcció:"
	@echo "	all	Neteja i genera l'executable"
	@echo "	build	Crea un executable"
	@echo "	clean	Elimina els fitxers generats per el makefile"
	@echo "	dist	Crea les distribucions de codi font i de paquet"
	@echo "	req	Instal·la els requeriments del projecte"
	@echo "	help	Mostra aquestes instruccions"

author:
	@echo "Projecte demo M13-Projecte DAM"
	@echo "https://gitlab.com/rnadalb/dam2-m13"