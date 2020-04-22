#!/bin/bash -x

gfsh run --file=./createCluster.gfsh

"$@"
while true; do
    sleep 10
done