(defproject {{ns-name}} "0.1.0-SNAPSHOT"
  :dependencies [[thheller/shadow-cljs "2.8.39"]

                 ; core:
                 [org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.520"]
                 [reagent "0.8.1"]
                 [re-frame "0.10.7"]

                 ; navigation:
                 [clj-commons/secretary "1.2.4"]
                 [kibu/pushy "0.3.8"]

                 ; util:
                 [com.cemerick/url "0.1.1"]]

  :source-paths ["src/main"]

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.9.10"]
                   [day8.re-frame/re-frame-10x "0.4.0"]
                   [day8.re-frame/tracing "0.5.1"]
                   [figwheel-sidecar "0.5.18"]
                   [cider/piggieback "0.4.1"]]

    :source-paths ["src/dev"]

    :plugins      [[lein-figwheel "0.5.18"]
                   [lein-doo "0.1.10"]
                   [lein-pdo "0.1.1"]]}

   :prod {:dependencies [[day8.re-frame/tracing-stubs "0.5.1"]]}})

