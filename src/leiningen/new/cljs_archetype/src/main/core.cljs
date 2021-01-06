(ns {{ns-name}}.core
  (:require [reagent.dom :as rdom]
            [re-frame.core :as re-frame]
            [{{ns-name}}.events :as events]
            [{{ns-name}}.routes :as routes]
            [{{ns-name}}.views :as views]
            [{{ns-name}}.fx]
            [{{ns-name}}.subs]))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (rdom/render [views/main]
               (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [::events/initialize-db])
  (routes/app-routes)
  (mount-root))

