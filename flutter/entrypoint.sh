#!/bin/sh

cd /work

clojure -Sdeps '{:deps {net.clojars.clojuredart/flutter {:local/root "./flutter/"}}}' -Tnew create :template clojuredart/flutter :name user/flutter-app

clj -M:cljd flutter -d web-server --web-port=1234
