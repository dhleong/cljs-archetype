(ns {{ns-name}}.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [{{ns-name}}.events :as events]
            [{{ns-name}}.routes :as routes]
            [{{ns-name}}.views :as views]
            [{{ns-name}}.fx]
            [{{ns-name}}.subs]))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [::events/initialize-db])
  (routes/app-routes)
  (mount-root))

