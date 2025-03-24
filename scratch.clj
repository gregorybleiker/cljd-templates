(ns clojuredart.cli
  (:require [clojure.tools.build.api :as b]))

(defn cljd-upgrade [target-dir]
  "Init clojuredart file"
  (let [basis    (b/create-basis {:aliases [:build]
                                  :root (str target-dir "deps.edn")
                                  :dir (str target-dir)})
        cmds     (b/java-command
                  {:basis      basis
                   :dir target-dir
                   :out :capture
                   :err :capture
                   :main      'clojure.main
                   :main-args ["-m" "cljd.build" "compile"]})
        {:keys [exit out err]} (b/process
                        (assoc cmds :dir target-dir))]
    (when-not (zero? exit) (throw (ex-info (str "Upgrade failed -" cmds "-" err "-") {})))))
