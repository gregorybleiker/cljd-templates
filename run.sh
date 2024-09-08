#!/bin/sh
clojure -Sdeps '{:deps {net.clojars.clojuredart-greg2/cli {:local/root "./dart-cli/"}}}' -Tnew create :template clojuredart-greg/cli :name myusername/dartapp
