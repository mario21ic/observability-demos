#!/bin/bash

cd service2 && \
java -javaagent:../opentelemetry-javaagent.jar -jar target/demo-0.0.1-SNAPSHOT.jar
