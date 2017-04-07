(ns tournament.views
    (:require [re-frame.core :as re-frame]
              [re-com.core :as re-com]
              [tournament.team.views :as team]
              [reagent.core :as reagent]))


;; home
(defn welcome-title []
  [re-com/title
       :label (str "Welcome to awesome Tournament site!")
       :level :level1]
  )

(defn link-to-about-page []
  [re-com/hyperlink-href
   :label "go to About Page"
   :href "#/about"])

(defn team-list-item [team]
  [re-com/hyperlink-href
   :label team
   :href (str "#/team/" team)])

(defn team-list []
  (let [teams (re-frame/subscribe [:teams])]
    (fn []
      [re-com/v-box
       :children [[team-list-item "discendum"]]]
      
      
      )))

(defn team-input []
  (let [team-val (reagent/atom "")]
    (fn []
      [re-com/v-box
       :children [[re-com/label :label "Your team:"]
                  [re-com/gap :size "5px"]
                  [re-com/input-text
                   :model team-val
                   :on-change #(reset! team-val %)
                   :placeholder "Set your team name"]]])))





(defn home-panel []
  [re-com/v-box
   :gap "1em"
   :children [[welcome-title] [team-list]]])




;; about

(defn about-title []
  [re-com/title
   :label "This is the About Page."
   :level :level1])

(defn link-to-home-page []
  [re-com/hyperlink-href
   :label "go to Home Page"
   :href "#/"])

(defn about-panel []
  [re-com/v-box
   :gap "1em"
   :children [[about-title] [link-to-home-page]]])


;; main

(defn- panels [panel-name]
  (case panel-name
    :team-panel [team/team-panel]
    :home-panel [home-panel]
    :about-panel [about-panel]
    :team-home-panel [home-panel]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [:active-panel])]
    (fn []
      [re-com/v-box
       :height "100%"
       :children [[panels @active-panel]]])))
