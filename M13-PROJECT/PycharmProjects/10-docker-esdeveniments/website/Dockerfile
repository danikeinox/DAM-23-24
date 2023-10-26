FROM ubuntu/apache2:latest
LABEL authors="K3IN0X"
MAINTAINER Daniel Cabrera <daniel@danielcabrera.es>

COPY ./index.html /var/www/html

CMD ["apache2ctl", "-D", "FOREGROUND"]