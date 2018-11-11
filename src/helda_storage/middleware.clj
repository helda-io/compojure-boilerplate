(ns helda-storage.middleware
  (:require
            [environ.core :refer [env]]

            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.logger :as logger]
            [ring.middleware.reload :refer [wrap-reload]]
    )
  )

(defn wrap-dev-middleware [handler]
  (if (env :dev)
    (-> handler
        logger/wrap-with-body-logger
        wrap-reload
      )
    handler
    )
  )

(defn wrap-middleware [handler]
  (-> handler
    wrap-params
    (wrap-json-body {:keywords? true :bigdecimals? true})
    wrap-json-response
    logger/wrap-with-logger ;todo this adds some garbage in logs
    wrap-dev-middleware
    )
  )
