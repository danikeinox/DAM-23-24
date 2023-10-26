FROM python:3.11
ENV PYTHONDONTWRITEBYTECODE=1
ENV PYTHONUNBUFFERED=1

WORKDIR /opt/project
COPY requirements.txt /opt/project/

RUN python -m pip install --upgrade pip
RUN pip install -r requirements.txt

COPY . /opt/project

#FROM python:3.11-slim-bullseye AS build
#WORKDIR /wheels
#
#COPY requirements.txt /opt/project/
#RUN apt-get update \
#  && apt-get install -y build-essential \
#  && pip3 wheel -r /opt/project/requirements.txt
#
#FROM python:3.11-slim-bullseye
#WORKDIR /opt/project/
#
#COPY --from=build /wheels /wheels
#COPY . /opt/project/
#
#RUN pip3 install --no-cache-dir -r requirements.txt -f /wheels \
#  && rm -rf /wheels
#
#WORKDIR /opt/project/dockerpd/
#
#ENTRYPOINT ["python", "dockerpd.py"]
