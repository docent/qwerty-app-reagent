(ns repl.repl
  (:require [ktoa.repl :as repl :refer-macros [start-repl]]))

(start-repl {:app-name "QwertyApp"
             :base-url "http://localhost:3449/js"
             :root-ns  "qwerty.core"
             :modules ["react-native"]})
