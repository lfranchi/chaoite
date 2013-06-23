(defproject chaoite "0.1.0-SNAPSHOT"
  :description "A graphite explorer for drilling into interactive data"
  :url "http://github.com/lfranchi/chaoite"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :source-paths ["src-clj"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.0.4"]
                 [hiccup "1.0.3"]
                 [org.clojure/google-closure-library-third-party "0.0-2029"]
                 [domina "1.0.0"]]
  :plugins [[lein-cljsbuild "0.3.2"]
            [lein-ring "0.7.0"]]
  :cljsbuild {
              :builds [{:source-paths ["src-cljs"]
                        :compiler {:output-to "resources/public/js/main.js"}
                        :optimizations :whitespace
                        :pretty-print true}]}
  :ring {:handler chaoite.routes/app})
