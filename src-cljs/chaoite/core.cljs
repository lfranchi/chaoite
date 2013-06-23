(ns chaoite.core
  (:use [domina.events :only [listen!]])
  (:require [clojure.browser.repl :as repl]
            [clojure.browser.event :as event]
            [domina :as d]
            ))

;; (repl/connect "http://127.0.0.1:9000/repl")

(defn log
  [& args]
  (.log js/console (apply str args)))

(defn parse-graphite-url
  [url]
  (log "Got URL: " url))

;; (listen! (d/by-id "test")
;;            :click
;;            (fn [evt]
;;              (log "Got event!")
;;              (prevent-default evt)))

(event/listen
 (d/by-id "load-button")
 "click"
 (fn [e]
   (let [url (d/value (d/by-id "url-input"))]
     (parse-graphite-url url))
   (.preventDefault e)))
