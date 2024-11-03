#!/bin/bash

cmd=docker
if [[ $(command -v podman) ]]
then
    echo "using podman"
    cmd=podman
elif [[ $(command -v docker) ]]
then
    echo "using docker"
else
    echo "no container runtime found"
    exit -1
fi

$cmd build -f flutter/Dockerfile -t flutterapp .
