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


(defn users []
  (let [users (re-frame/subscribe [:users])]
    [:div (for [user @users]
            [:div {:key user} user])]))

(defn userform []
  (let [val (reagent/atom "")]
    (fn []
      [re-com/v-box
       :children [[re-com/label :label "new-user"]
                  [re-com/gap :size "5px"]
                  [re-com/input-text
                   :model val
                   :on-change #(swap! val %)
                   :placeholder "set new player"]
                  [re-com/button
                   :label "save"
                   :on-click (re-frame/dispatch [:set-user @val])]]])))


(defn team-panel []
  [re-com/v-box
   :gap "1em"
   :children [[welcome-title] [users] [userform]]])
