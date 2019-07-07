(ns {{ns-name}}.events
  (:require [re-frame.core :refer [dispatch reg-event-db reg-event-fx
                                   path
                                   inject-cofx trim-v]]
            [{{ns-name}}.db :as db]))

(reg-event-db
  ::initialize-db
  (fn [_ _]
    db/default-db))

(reg-event-db
  :navigate!
  [trim-v]
  (fn [db page-spec]
    (assoc db :page page-spec)))
