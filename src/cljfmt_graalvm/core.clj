(ns cljfmt-graalvm.core
  (:require [cljfmt.core :as fmt]
            [clojure.java.io :as io])
  (:gen-class))

(defn -main
  ([] (-main "-"))
  ([in-file]
   (if (-> in-file (io/file) .exists)
     (let [s (fmt/reformat-string (slurp in-file))]
       (spit in-file s))
     (-> (slurp *in*) (fmt/reformat-string) (println)))))
