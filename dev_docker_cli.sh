#!/bin/sh

podman run -d -v ./work:/work --name dev_dartcli --entrypoint /bin/sleep dartcli infinity
podman exec -it dev_dartcli /entrypoint.sh
podman exec -it dev_dartcli bash
# podman exec -it dev_dartcli bash
