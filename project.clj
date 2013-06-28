(defproject org.clojars.luminousmonkey/greentree-interface "0.0.2-SNAPSHOT"
  :description "Clojure library for interfacing with Greentree."
  :url "http://example.com/FIXME"
  :license {:name "BSD 2-Clause Licence"
            :url "http://opensource.org/licenses/BSD-2-Clause"
            :distribution :repo}
  :min-lein-version "2.0.0"
  :source-paths ["src/clojure"]
  :java-source-paths ["src/java"]
  :repositories [["snapshots" "file://C:/Users/Mike Aldred/.m2/repository"]]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojars.luminousmonkey/javajom "6.3.9.1"]
                 [org.clojars.luminousmonkey/javajom-native "6.3.9.1"]]
  :profiles {:dev {:source-paths ["dev"]
                   :dependencies [[org.clojure/tools.namespace "0.2.3"]
                                  [org.clojure/java.classpath "0.2.0"]
                                  [midje "1.6-alpha2"]]}})
