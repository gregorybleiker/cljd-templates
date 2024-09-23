#!/bin/sh

podman run -p 1234:1234 -d -v ./work:/work --name dev_flutter --entrypoint /bin/sleep flutterapp infinity
podman exec -it dev_flutter /entrypoint.sh
podman exec -it dev_flutter bash
# podman exec -it dev_dartcli bash
