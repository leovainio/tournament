(ns tournament.team.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :users
 (fn [db]
   (:users db)))


