(ns clojuredart-greg.cli
(:require [clojure.tools.build.api :as b]
;  [deps-deploy.deps-deploy :as dd])
))

(defn data-fn
  "Example data-fn handler.

  Result is merged onto existing options data."
  [data]
  ;; returning nil means no changes to options data
  (println "data-fn returning nil")
  nil)

(defn template-fn
  "Example template-fn handler.

  Result is used as the EDN for the template."
  [edn data]
  ;; must return the whole EDN hash map
  (println "template-fn returning edn")
  edn)

(defn cljd-init [target-dir]
  "Init clojuredart file"
  (let [basis    (b/create-basis {:aliases [:build]
                                  :root (str "./" target-dir "/deps.edn")
                                  :dir (str "./" target-dir)
                                  })
        cmds     (b/java-command
                  {:basis      basis
                   :dir target-dir
                   :main      'clojure.main
                   :main-args ["-m" "cljd.build" "init"]})
        {:keys [exit]} (b/process
                        (assoc cmds :dir target-dir))]
    (when-not (zero? exit) (throw (ex-info "Init failed" {})))))

(defn cljd-upgrade [target-dir]
  "Init clojuredart file"
  (let [basis    (b/create-basis {:aliases [:build]
                                  :root (str "./" target-dir "/deps.edn")
                                  :dir (str "./" target-dir)
                                  })
        cmds     (b/java-command
                  {:basis      basis
                   :dir target-dir
                   :main      'clojure.main
                   :main-args ["-m" "cljd.build" "upgrade"]})
        {:keys [exit]} (b/process
                        (assoc cmds :dir target-dir))]
    (when-not (zero? exit) (throw (ex-info "Upgrade failed" {})))))

(defn cljd-compile [target-dir]
  "Init clojuredart file"
  (let [basis    (b/create-basis {:aliases [:build]
                                  :root (str "./" target-dir "/deps.edn")
                                  :dir (str "./" target-dir)
                                  })
        cmds     (b/java-command
                  {:basis      basis
                   :dir target-dir
                   :main      'clojure.main
                   :main-args ["-m" "cljd.build" "compile"]})
        {:keys [exit]} (b/process
                        (assoc cmds :dir target-dir))]
    (when-not (zero? exit) (throw (ex-info "Compile failed" {})))))


(defn post-process-fn
  "Example post-process-fn handler.

  Can programmatically modify files in the generated project."
  [edn data]
  (cljd-init (:target-dir data))
  (cljd-upgrade (:target-dir data))
  (cljd-compile (:target-dir data))
)
