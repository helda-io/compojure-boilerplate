(ns helda-storage.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :refer [response status]]
            [helda-storage.middleware :refer [wrap-middleware]]
    )
  )

(defroutes app-routes
  (context "/api" []
    (GET "/ping" [] (response {:status "ok"}))
    (route/not-found "Not Found")
    )
  )

(def app
  (wrap-middleware app-routes)
  )
