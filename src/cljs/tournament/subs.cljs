(ns tournament.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :name
 (fn [db]
   (:name db)))

(re-frame/reg-sub
 :teams
 (fn [db]
   (:teams db)))

(re-frame/reg-sub
 :team
 (fn [db]
   (:team db)))

(re-frame/reg-sub
 :active-panel
 (fn [db _]
   (:active-panel db)))
