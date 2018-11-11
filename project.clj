(defproject helda-storage "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [
    [org.clojure/clojure "1.9.0"]
    [compojure "1.6.1"]
    [ring/ring-json "0.4.0"]
    [ring-logger "0.7.7"]
    [cheshire "5.8.1"]
    [com.novemberain/monger "3.1.0"]
    [environ "1.1.0"]
    ]
  :plugins [[lein-ring "0.12.4"]]
  :ring {:handler helda-storage.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
