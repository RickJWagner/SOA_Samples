#!/bin/bash

# These curl scripts work against BPMS 6.0.3.  See doc for more commands available.

#curl -u erics:bpmsuite1! -i -H "Accept: application/json" -X POST http://localhost:8180/business-central/rest/runtime/org.flyingdog:ProjectFromMaciYoutube:1.0/process/ProjectFromMaciYoutube.IncrementAge2/start?map_name=Rick&map_age=50

# Gets process info, but no WorkItems
#curl -u erics:bpmsuite1! -i -H "Accept: application/json" -X GET http://localhost:8180/business-central/rest/runtime/org.flyingdog:ProjectFromMaciYoutube:1.0/process/instance/1

# Lists the tasks
#curl -u erics:bpmsuite1! -i -H "Accept: application/json" -X GET http://localhost:8180/business-central/rest/task/query

# Starts a task
# curl -u erics:bpmsuite1! -i -H "Accept: application/json" -X POST http://localhost:8180/business-central/rest/task/4/start

# Complete the task
curl -u erics:bpmsuite1! -i -H "Accept: application/json" -X POST http://localhost:8180/business-central/rest/task/4/complete?_age=17&_name=TaskCompleteText

