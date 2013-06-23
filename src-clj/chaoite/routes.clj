(ns chaoite.routes
  (:use compojure.core
        chaoite.views
        [hiccup.middleware :only (wrap-base-url)]
        [ring.middleware.reload :only (wrap-reload)])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [compojure.response :as response]))

(defroutes main-routes
  (GET "/" [] (index-page))
  (route/resources "/")
  (route/not-found "Page not found :-/"))

(def app
  (-> (handler/site main-routes)
      (wrap-reload '[chaoite.views])
      (wrap-base-url)))
