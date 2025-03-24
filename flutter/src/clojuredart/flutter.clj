(ns clojuredart.flutter
  (:require [clojure.tools.build.api :as b]
            [utils.commands :as c]
            ))

(defn data-fn
  "Empty data fn"
  [data]
  ;; returning nil means no changes to options data
  nil)

(defn template-fn
  "Empty template fn"
  [edn data]
  ;; must return the whole EDN hash map
  edn)

(defn post-process-fn
  "run init, upgrade and compile on created project"
  [edn data]
  (c/cljd-init (:target-dir data))
  (c/cljd-upgrade (:target-dir data))
  (c/cljd-compile (:target-dir data))
  (c/git-init (:template-dir data)  (:target-dir data)))
