(defproject qwerty "0.0.1"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.189"]
                 [reagent "0.5.1"]
                 [figwheel-sidecar "0.5.0-SNAPSHOT"]
                 [com.cemerick/piggieback "0.2.1"]
                 [ktoa "0.1.2-SNAPSHOT"]]
  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-figwheel "0.5.0-1"]]
  :clean-targets ^{:protect false} ["QwertyApp/index.android.js"]
  :source-paths ["src"]
  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]
                 :init (do (use 'figwheel-sidecar.repl-api)(start-figwheel!))}
  :profiles {:mobile {:dependencies [[reagent "0.5.1" :exclusions [cljsjs/react cljsjs/react-dom]]]
                      :cljsbuild {:builds {:release {:source-paths ["src/react"]}}}}}
  :cljsbuild {:builds {:repl {:source-paths ["src/repl" ]
                              :compiler {:optimizations :advanced
                                         :output-to "QwertyApp/index.android.js"}}
                       :dev {:source-paths ["src/qwerty" ]
                             :figwheel {:websocket-host "localhost"}
                             :compiler {:main qwerty.core
                                        :asset-path "js"
                                        :output-dir "resources/public/js"}}
                       :release {:source-paths ["src/qwerty"]
                                 :compiler {:optimizations :advanced
                                            :output-to "QwertyApp/release.js"}}}})
