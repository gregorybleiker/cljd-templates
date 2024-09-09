#!/bin/sh
clojure -Sdeps '{:deps {net.clojars.clojuredart/flutter {:local/root "./flutter/"}}}' -Tnew create :template clojuredart/flutter :name user/flutter-app
