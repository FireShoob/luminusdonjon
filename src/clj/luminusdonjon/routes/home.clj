(ns luminusdonjon.routes.home
  (:require
   [luminusdonjon.layout :as layout]
   [clojure.java.io :as io]
   [luminusdonjon.middleware :as middleware]
   [ring.util.response]
   [ring.util.http-response :as response]))

(defn home-page [request]
  (layout/render request "home.html"))

(defn home-routes []
  [""
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats
                 middleware/wrap-return-favicon]}
   ["/" {:get home-page}]
   ["/docs" {:get (fn [_]
                    (-> (response/ok (-> "docs/docs.md" io/resource slurp))
                        (response/header "Content-Type" "text/plain; charset=utf-8")))}]
   ["/about" {:get (fn [_]
                     (-> (response/ok (-> "docs/about.md" io/resource slurp))
                         (response/header "Content-Type" "text/plain; charset=utf-8")))}]])

