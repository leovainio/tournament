(ns tournament.team.views
    (:require [re-frame.core :as re-frame]
              [re-com.core :as re-com]
              
              [reagent.core :as reagent]))


;; home

(defn welcome-title []
  (let [team (re-frame/subscribe [:team])]
    (fn []
      [re-com/title
       :label (str @team " site!")
       :level :level1])))






(defn team-panel []
  [re-com/v-box
   :gap "1em"
   :children [[welcome-title]]])
