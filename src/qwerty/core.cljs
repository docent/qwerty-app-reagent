(ns qwerty.core
  (:require
    [ktoa.components :refer [view text]]
    [ktoa.core :as ktoa]
    [reagent.core :as r]
    [qwerty.state :refer [app-state]]))

(enable-console-print!)

(when ktoa/react-native
  (set! js/React (js/require "react-native/Libraries/react-native/react-native.js")))

(defn render-mobile []
  (let [View (r/adapt-react-class (.-View ktoa/react-native))
        Text (r/adapt-react-class (.-Text ktoa/react-native))]
    [View
     [Text "Mobile:"]
     [Text "Mobile:" (:msg @app-state)]]))

(defn render-browser []
  [:div
   [:div "Browser:"]
   [:div (:msg @app-state)]])

(defn RootComponent []
  (if ktoa/react-native
    (fn [] [render-mobile])
    (fn [] [render-browser])))

(ktoa/register! "RootViewRN"
                #(r/render [RootComponent] %)
                #(.querySelector js/document "#app"))
