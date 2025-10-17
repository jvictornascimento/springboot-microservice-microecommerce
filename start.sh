#!/bin/bash


set -e  # faz o script parar em caso de erro

docker compose -p microservico -f docker-compose.yml up -d

until $(curl -s http://localhost:8888/actuator/health | grep -q '"status":"UP"'); do
  echo "Aguardando Config Server ficar disponivel"
  sleep 5
done

docker compose -p microservico -f ms-user/docker-compose.ms-user.yml up -d
docker compose -p microservico -f ms-product-catalog/docker-compose.ms-product-catalog.yml up -d