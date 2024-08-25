#!/bin/sh
clojure -Sdeps '{:deps {net.clojars.clojuredart-greg/cli {:local/root "."}}}' -Tnew create :template clojuredart-greg/cli :name myusername/mycoollib
