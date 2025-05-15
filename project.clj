;;   Copyright (c) Dragan Djuric. All rights reserved.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php) or later
;;   which can be found in the file LICENSE at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(defproject uncomplicate/deep-diamond "0.32.0-SNAPSHOT"
  :description "Fast Clojure Deep Learning Library"
  :author "Dragan Djuric"
  :url "http://github.com/uncomplicate/deep-diamond"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.12.0"]
                 [org.uncomplicate/neanderthal-base "0.54.0-SNAPSHOT"]
                 [org.uncomplicate/neanderthal-mkl "0.54.0-SNAPSHOT"]
                 [org.uncomplicate/neanderthal-cuda "0.54.0-SNAPSHOT"]
                 [org.bytedeco/dnnl-platform "3.7.3-1.5.12-SNAPSHOT"]]

  :profiles {:dev {:plugins [[lein-midje "3.2.1"]
                             [lein-codox "0.10.8"]]
                   :resource-paths ["data"]
                   :global-vars {*warn-on-reflection* true
                                 *assert* false
                                 *unchecked-math* :warn-on-boxed
                                 *print-length* 128}
                   :dependencies [[midje "1.10.10"]
                                  [codox-theme-rdash "0.1.2"]
                                  [org.clojure/data.csv "1.1.0"]
                                  [org.bytedeco/mkl "2025.0-1.5.11" :classifier linux-x86_64-redist]
                                  [org.bytedeco/cuda "12.8-9.8-1.5.12-SNAPSHOT"  :classifier linux-x86_64-redist]]
                   :codox {:metadata {:doc/format :markdown}
                           :source-uri "http://github.com/uncomplicate/deep-diamond/blob/master/{filepath}#L{line}"
                           :themes [:rdash]
                           :namespaces [uncomplicate.diamond.tensor
                                        uncomplicate.diamond.dnn
                                        uncomplicate.diamond.metrics
                                        uncomplicate.diamond.native
                                        uncomplicate.diamond.internal.protocols]
                           :output-path "docs/codox"}

                   :jvm-opts ^:replace ["-Dclojure.compiler.direct-linking=true" "-Djdk.attach.allowAttachSelf"]}}

  :repositories [["snapshots" "https://oss.sonatype.org/content/repositories/snapshots"]]

  :javac-options ["-target" "1.8" "-source" "1.8" "-Xlint:-options"]
  :source-paths ["src/clojure" "src/device"])
