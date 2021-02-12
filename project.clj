;
;  (C) Copyright 2017, 2018, 2020, 2021  Pavel Tisnovsky
;
;  All rights reserved. This program and the accompanying materials
;  are made available under the terms of the Eclipse Public License v1.0
;  which accompanies this distribution, and is available at
;  http://www.eclipse.org/legal/epl-v10.html
;
;  Contributors:
;      Pavel Tisnovsky
;

(defproject org.clojars.tisnik/clj-utils "0.3.0-SNAPSHOT"
  :description "Simple library to read and parse INI files."
  :url "https://github.com/tisnik/clj-utils"
  :license {:name "Eclipse Public License",
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :plugins [[codox "0.10.7"]
            [test2junit "1.1.0"]
            [lein-cloverage "1.0.7-SNAPSHOT"]]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
