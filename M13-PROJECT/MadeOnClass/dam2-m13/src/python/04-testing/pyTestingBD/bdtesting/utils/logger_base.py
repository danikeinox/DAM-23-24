import logging as log

# Gestió centralitzda dels log
log.basicConfig(level=log.DEBUG,
                format='%(asctime)s: %(levelname)s [%(filename)s:%(lineno)s] %(message)s',
                datefmt='%I:%M:%S %p',
                handlers=[
                    log.FileHandler('../pyTestingBD.log'),
                    log.StreamHandler()
                ])

if __name__ == '__main__':
    log.debug('Missatge [DEBUG]')
    log.info('Missatge [INFO]')
    log.warning('Missatge [WARNING]')
    log.error('Missatge [ERROR]')
    log.critical('Missatge [CRÍTIC]')
