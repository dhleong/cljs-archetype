(ns leiningen.new.options.base
  (:require [leiningen.new.options.helpers :refer [->files]]))

(defn files [data]
  (->files
    data

    [".clj-kondo/config.edn" "clj-kondo/config.edn"]
    "karma.conf.js"
    "README.md"
    "package.json"
    "shadow-cljs.edn"
    "public/index.html"
    [".gitignore" "gitignore"]

    [:main "core.cljs"]
    [:main "db.cljs"]
    [:main "events.cljs"]
    [:main "fx.cljs"]
    [:main "routes.cljs"]
    [:main "subs.cljs"]
    [:main "views.cljs"]
    [:main "views/home.cljs"]))
