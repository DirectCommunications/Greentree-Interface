(defproject greentree-interface "0.1.0-SNAPSHOT"
  :description "Clojure library for interfacing with Greentree."
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.0.0"
  :source-paths ["src/clojure"]
  :java-source-paths ["src/java"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojars.luminousmonkey/javajom "6.3.9.1"]
                 [org.clojars.luminousmonkey/javajom-native "6.3.9.1"]]
  :profiles {:dev {:source-paths ["dev"]
                   :dependencies [[org.clojure/tools.namespace "0.2.3"]
                                  [org.clojure/java.classpath "0.2.0"]]}})
