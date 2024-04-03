# syntax=docker/dockerfile:1

FROM python:3.8-slim-buster

WORKDIR /python-docker

COPY ./requirements.txt /python-docker
RUN pip install -r requirements.txt

COPY . .

CMD ["flask", "run", "--host" ,"0.0.0.0"]
