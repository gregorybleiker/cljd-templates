(ns utils.commands
  (:require [clojure.tools.build.api :as b]
             ))

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

(defn git-init [source-dir target-dir]
  "Init git repository"
  (do (b/git-process
       {:git-args "init --initial-branch=main"
        :dir target-dir})
      (b/copy-file {:src (str source-dir "/root/.gitignore") :target (str target-dir "/.gitignore") })
      (b/git-process
       {:git-args "add ."
        :dir target-dir})
      (b/git-process
       {:git-args ["commit", "-m", "Initial commit"]
        :dir target-dir})))
