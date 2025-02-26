Dependencies:
```
docker compose up -d
wget https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v2.13.1/opentelemetry-javaagent.jar
```

Start services:
```
./service1_start.sh
./service2_start.sh
```


```
curl localhost:8080
```

