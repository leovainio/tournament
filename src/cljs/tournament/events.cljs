(ns tournament.events
    (:require [re-frame.core :as re-frame]
              [tournament.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
 :set-active-panel
 (fn [db [_ active-panel]]
   (assoc db :active-panel active-panel)))

(re-frame/reg-event-db
 :set-user
 (fn [db [_ user]]
   (assoc db :users user)))

(re-frame/reg-event-db
 :team-name-update
 (fn [db [_ team]]
   
   (assoc db :team team)
   ))
