import logging

# Creación del logger que muestra la información únicamente por fichero.
logging.basicConfig(
    format='%(asctime)-5s %(name)-15s %(levelname)-8s %(message)s',
    level=logging.INFO,  # Nivell dels esdeveniments que registra el logger
    filename="logs_info.log",  # Fitxer on s'escriuen els logs
    filemode="a"  # a ("append"), mode d'escriptura, si existeix -> afegir al final
)


def log_info(message):
    logging.info(message)
    logging.shutdown()
