(ns chaoite.views
  (:require
   [hiccup
    [page :refer [html5]]
    [page :refer [include-js]]
    [element :refer [javascript-tag]]]))

(defn index-page []
  (html5
   [:head
    [:title "Chaoite: Explore Graphite"]]
   [:body
    [:div#header
     [:h1 "Welcome to Chaoite"]
     [:p "Chaoite is a tool for interactively analyzing Graphite data"]]
    [:div#urlentry
     [:h3 "Please enter a Graphite URL"]
     [:form
      [:input#url-input {:type "text"}]
      [:input#load-button {:type "submit" :value "Load Data"}]]]
    (javascript-tag "var CLOSURE_NO_DEPS = true;")
    (include-js "/js/main.js")]))