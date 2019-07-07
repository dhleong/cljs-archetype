(ns leiningen.new.cljs-archetype
  (:require [leiningen.new.templates :refer [renderer sanitize-ns name-to-path ->files]]
            [leiningen.core.main :as main]
            [leiningen.new.options.base :as base]))

(def render (renderer "cljs-archetype"))

(defn app-files [data _options]
  (concat
    (base/files data)))

(defn template-data [name _options]
  {:name      name
   :ns-name   (sanitize-ns name)
   :sanitized (name-to-path name)})

(defn cljs-archetype [name & options]
  (let [data (template-data name options)]
    (main/info "Generating fresh 'lein new' cljs-archetype project.")
    (apply ->files data
           (app-files data options))))
