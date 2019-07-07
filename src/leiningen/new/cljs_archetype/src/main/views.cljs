(ns {{ns-name}}.views
  (:require [{{ns-name}}.util :refer [<sub]]
            [{{ns-name}}.views.error-boundary :refer [error-boundary]]
            [{{ns-name}}.views.home :as home]))

(def ^:private pages
  {:home #'home/view})

(defn main []
  (let [[page args] (<sub [:page])
        page-form [(get pages page) args]]
    (println "[router]" page args page-form)

    [error-boundary
     page-form]))

