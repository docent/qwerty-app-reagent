(ns qwerty.core
  (:require
    [ktoa.components :refer [view text]]
    [ktoa.core :as ktoa]
    [reagent.core :as r]
    [qwerty.state :refer [app-state]]))

(def View (r/adapt-react-class (.-View ktoa/react-native)))
(def Text (r/adapt-react-class (.-Text ktoa/react-native)))

(defn render-mobile []
  [View
   [Text "Mobile:"]
   [Text "Mobile:" (:msg @app-state)]])


  (defn render-browser []
    [:div
     [:div "Browser:"]
     [:div (:msg @app-state)]])

  (defn RootComponent []
    (if ktoa/react-native
      #([render-mobile])
      #([render-browser])))

  (ktoa/register! "RootViewRN"
                  #(r/render RootComponent %)
                  #(.querySelector js/document "#app"))
