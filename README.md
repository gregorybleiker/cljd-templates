# About

Templates and Dockerfiles for building clojuredart projects with deps-new

There are two flavours:
- pure dart (cli)
- flutter (UI)

## Prerequisites

Scripts are all for Linux systems. Windows is currently not supported.

You need `clojure` and `dart` installed on your system.

Run (only once):

    $ clojure -Ttools install-latest :lib io.github.seancorfield/deps-new :as new

### Optional (highly recommended)

- [babashka](https://github.com/babashka/babashka)
- To run the guided setup (`bb create`), you need to install  and [gum](https://github.com/charmbracelet/gum).

### Flutter
If you are developing a flutter app, you need the tooling installed to build the flutter app (eg. android sdk)


## Getting Started

### Native (no containers)

Everything is going to run on your local machine. This requires all dependencies to be setup correctly.

The easiest way to get something running is to clone this repo, install the [optional dependencies](#optional-highly-recommended) and run:

    $ bb create

Sample invocations with `clojure` are in `run*.sh`.

### Containers (WIP)
You can use containers to generate your project structure (and the continue down the native path (see above). Or you can also run the application inside of a container, which will have all requirements installed inside the container. At the moment, only flutter web development and dart/cli is supported.

#### Docker
If you plan on using containers for creation or development, you need some kind of container runtime. This repo uses `podman` by default and tries to fallback to `docker` in the samples. You need to install the container runtime and tooling yourself.

Build the container with `build_docker_cli.sh`

Then
- Create a `work` directory
- Run `run_docker_cli.sh`

This will create the app in the `work` directory

If you want to run all commands in the container, run `dev_docker_cli.sh` instead of `run_docker_cli.sh`. This will keep the container running and you'll be dropped into a shell in the container. Go into `/work/cli-app` and run `dart run`.


# References
https://blog.logrocket.com/containerizing-flutter-web-apps-with-docker/
