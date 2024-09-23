# About

Templates and Dockerfiles for building clojuredart projects with deps-new

## Prerequisites

You need `clojure` and `dart` installed on your system.
To run the guided setup, you need to install (babashka)[https://github.com/babashka/babashka] and (gum)[https://github.com/charmbracelet/gum].
If you are developing a flutter app, you need the tooling installed to build the flutter app (eg. android sdk)

## Getting Started

There are two ways to use the templates. Either for local development, which assumes that everything is going to run on your local machine. This requires all dependencies to be setup correctly. You can also run the templates through a docker container. You can either just generate the files through the tooling in the container or also run the whole application inside a container, in which case you need nearly no local setup, but the setup for development and debugging is more challenging.

### Local

The easiest way to get something running if you have all prerequisites installed, is

    $ bb create

If you have clojure installed, you need to run (only once to instal

    $ clojure -Ttools install-latest :lib io.github.seancorfield/deps-new :as new

Without cloning, you can run

    $ clojure -Tnew create :template com.github.gregorybleiker/cljd-templates%clojuredart/cli :name <user>/<cli_app>

Replace <user> and <cli_app> to your likings.

Alternatively, you can clone this repo, `cd` into the cloned directory and run:

    $ clojure -Sdeps '{:deps {net.clojars.clojuredart/cli {:local/root "."}}}' -Tnew create :template clojuredart/cli :name <user>/<cli_app>

or (nicer to my mind)

    $ clj -M:new create --template com.github.gregorybleiker/cljd-templates%clojuredart/cli --name <user>/<cli_app>

Sample invocations are in `run.sh` and `run_git.sh`

### Docker

# References
https://blog.logrocket.com/containerizing-flutter-web-apps-with-docker/
