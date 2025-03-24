(ns clojuredart.flutter
  (:require [clojure.tools.build.api :as b]
                                        ;  [deps-deploy.deps-deploy :as dd])
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

(defn cljd-init [target-dir]
  "Init clojuredart file"

  (-> (b/process {:command-args ["clj" "-M:cljd" "init"]
                  :dir (str "./" target-dir)
                  :out
                  :capture })
      :out
      println
      ))

(defn cljd-upgrade [target-dir]
  "Init clojuredart file"
  (-> (b/process {:command-args ["clj" "-M:cljd" "upgrade"]
                  :dir (str "./" target-dir)
                  :out
                  :capture })
      :out
      println
      ))

(defn cljd-compile [target-dir]
  "Init clojuredart file"
  (-> (b/process {:command-args ["clj" "-M:cljd" "compile"]
                  :dir (str "./" target-dir)
                  :out
                  :capture })
      :out
      println))


(defn post-process-fn
  "run init, upgrade and compile on created project"
  [edn data]
  (cljd-init (:target-dir data))
  (cljd-upgrade (:target-dir data))
  (cljd-compile (:target-dir data))
  )
