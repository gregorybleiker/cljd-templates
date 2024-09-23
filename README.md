# About

Templates and Dockerfiles for building clojuredart projects with deps-new

## Prerequisites

You need `clojure` and `dart` installed on your system.
- To run the guided setup, you need to install (babashka)[https://github.com/babashka/babashka] and (gum)[https://github.com/charmbracelet/gum].
- If you are developing a flutter app, you need the tooling installed to build the flutter app (eg. android sdk)
- If you want to use docker, this repo samples are using podman, but you could easily change to docker

## Getting Started

There are two ways to use the templates. Either for local development, which assumes that everything is going to run on your local machine. This requires all dependencies to be setup correctly. You can also run the templates through a docker container. You can either just generate the files through the tooling in the container or also run the whole application inside a container, in which case you need nearly no local setup, but the setup for development and debugging is more challenging.

### Local

The easiest way to get something running if you have all prerequisites installed, is

    $ bb create

If you have clojure installed, you need to run (only once to instal

    $ clojure -Ttools install-latest :lib io.github.seancorfield/deps-new :as new

Without cloning, you can run

    $ clojure -Tnew create :template com.github.gregorybleiker/cljd-templates%dart-cli%clojuredart/cli :name <user>/<cli_app>

Replace <user> and <cli_app> to your likings.

Alternatively, you can clone this repo, `cd` into the cloned directory and run:

    $ clojure -Sdeps '{:deps {net.clojars.clojuredart/cli {:local/root "./dart-cli"}}}' -Tnew create :template clojuredart/cli :name <user>/<cli_app>

or (nicer to my mind)

    $ clj -M:new create --template com.github.gregorybleiker/cljd-templates%dart-cli%clojuredart/cli --name <user>/<cli_app>

Sample invocations are in `run.sh` and `run_git.sh`

### Docker

You can also run the app in a docker container:

First build the container with `build_docker_cli.sh`

Then
- Create a `work` directory
- Run `run_docker_cli.sh`

This will create the app in the `work` directory

If you want to run all commands in the container, run `dev_docker_cli.sh` instead of `run_docker_cli.sh`. This will keep the container running and you'll be dropped into a shell in the container. Go into `/work/cli-app` and run `dart run`.



# References
https://blog.logrocket.com/containerizing-flutter-web-apps-with-docker/
