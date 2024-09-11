(ns cdcli
  (:require [bblgum.core :as b]
             [babashka.process :as bp]))
;; Command only:

(defn choose []
  (let [apptype (first (:result (b/gum :choose ["dart cli" "flutter"] :header "Type of application")))
        username (first (:result (b/gum :input :placeholder "user name" )))
        appname (first (:result (b/gum :input :placeholder "app name")))]
    (let [confirm (:result (b/gum :confirm [(clojure.string/join " " ["Create" apptype username appname])] :as :bool))]
      (bp/shell (clojure.string/join "" ["clojure -Sdeps '{:deps {net.clojars.clojuredart/cli {:local/root \"./dart-cli/ \"}}}' -Tnew create :template clojuredart/cli :name user/cli-app"]))
    )
  )
)

;; Command with args:
                                        ; (b/gum :choose ["arg1" "arg2"])

;; Command with opts:
                                        ;(b/gum :file :directory true)

;; Command with opts and args:
                                        ;(b/gum :choose ["arg1" "arg2"] :header "Choose an option")
