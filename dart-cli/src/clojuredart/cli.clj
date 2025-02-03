(ns clojuredart.cli
  (:require [clojure.tools.build.api :as b]))

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
  (let [basis    (b/create-basis {:aliases [:build]
                                  :root (str "./" target-dir "/deps.edn")
                                  :dir (str "./" target-dir)})
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
                                  :dir (str "./" target-dir)})
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
                                  :dir (str "./" target-dir)})
        cmds     (b/java-command
                  {:basis      basis
                   :dir target-dir
                   :main      'clojure.main
                   :main-args ["-m" "cljd.build" "compile"]})
        {:keys [exit]} (b/process
                        (assoc cmds :dir target-dir))]
    (when-not (zero? exit) (throw (ex-info "Compile failed" {})))))

(defn git-init [target-dir]
  "Init git repository"
  (do (b/git-process
       {:git-args "init --initial-branch=main"
        :dir target-dir})
      (b/copy-file {:src (str "./" ".gitignore") :target target-dir})
      (b/git-process
       {:git-args "add ."
        :dir target-dir})
      (b/git-process
       {:git-args ["commit", "-m", "Initial commit"]
        :dir target-dir})))

(defn post-process-fn
  "run init, upgrade and compile on created project"
  [edn data]
  (cljd-init (:target-dir data))
;  (cljd-upgrade (:target-dir data))
;  (cljd-compile (:target-dir data))
  (git-init (:target-dir data)))
