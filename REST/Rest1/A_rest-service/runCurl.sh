#!/bin/bash
# curl -v -H "Content-Type: text/plain" -X POST --data "Hello" http://localhost:8080/saludar
curl -H "Content-Type: application/json" -X POST -d '{"Hello"}' http://localhost:8080/saludar


