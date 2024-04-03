# syntax=docker/dockerfile:1

FROM python:3.9-slim-buster

WORKDIR /python-docker

RUN apt-get update
RUN apt-get -y upgrade
RUN apt-get -y install git

COPY ./requirements.txt /python-docker
RUN pip install -r requirements.txt

COPY . .

CMD ["flask", "run", "--host" ,"0.0.0.0"]
