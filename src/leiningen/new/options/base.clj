(ns leiningen.new.options.base
  (:require [leiningen.new.options.helpers :refer [->files]]))

(defn files [data]
  (->files
    data

    "README.md"
    "project.clj"
    "shadow-cljs.edn"
    "public/index.html"
    [".gitignore" "gitignore"]

    [:main "core.cljs"]
    [:main "db.cljs"]
    [:main "events.cljs"]
    [:main "fx.cljs"]
    [:main "routes.cljs"]
    [:main "subs.cljs"]
    [:main "util.cljs"]
    [:main "views.cljs"]
    [:main "util/nav.cljs"]
    [:main "views/error_boundary.cljs"]
    [:main "views/home.cljs"]))
