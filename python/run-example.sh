#!/bin/bash

export FLASK_APP=main.py

#opentelemetry-instrument \
#    --traces_exporter console \
#    --metrics_exporter console \
#    flask run
opentelemetry-instrument flask run


