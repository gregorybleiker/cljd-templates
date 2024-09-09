#!/bin/sh
clojure -Sdeps '{:deps {net.clojars.clojuredart/cli {:local/root "./dart-cli/"}}}' -Tnew create :template clojuredart/cli :name user/cli-app
