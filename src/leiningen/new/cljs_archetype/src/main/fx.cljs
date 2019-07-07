(ns {{ns-name}}.fx
  (:require [re-frame.core :refer [reg-fx]]
            [{{ns-name}}.util.nav :as nav]))

(reg-fx
  :nav/replace!
  nav/replace!)
