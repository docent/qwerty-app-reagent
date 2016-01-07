(ns qwerty.state
    (:require [reagent.core :as r]))

(defonce app-state (r/atom {:msg "Hello cross-platform world!"}))
