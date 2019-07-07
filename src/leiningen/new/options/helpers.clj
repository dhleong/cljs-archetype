(ns leiningen.new.options.helpers
  (:require [leiningen.new.templates :refer [renderer sanitize]]
            [clojure.java.io :as io]))

(def template-name "cljs-archetype")

(def render-text (renderer template-name))

(defn resource-input
  "Get resource input stream. Useful for binary resources like images."
  [resource-path]
  (-> (str "leiningen/new/" (sanitize template-name) "/" resource-path)
      io/resource
      io/input-stream))

(defn render
  "Render the content of a resource"
  ([resource-path]
   (resource-input resource-path))
  ([resource-path data]
   (render-text resource-path data)))

(defn option? [option-name options]
  (boolean
   (some #{option-name} options)))

(defn invoke-option [option options]
  (fn [block]
    (if (option? option options) (str block) "")))

(defn ->files [data & files]
  (map (fn [f]
         (cond
           (string? f)
           [f (render f data)]

           (keyword? (first f))
           (let [src-dir (name (first f))
                 path-base (str "src/" src-dir "/")
                 rel-path (second f)]
             [(str path-base "{{sanitized}}/" rel-path)
              (render
                (str path-base rel-path)
                data)])

           (and (vector? f)
                (string? (second f)))
           [(first f) (render (second f) data)]

           ; full spec
           (vector? f)
           f

           :else (throw (IllegalArgumentException.
                          (str "Invalid spec: " f)))))

       files))
