(ns basic)

(require '[clojure.repl :refer :all])

(defn -main []
  (def x 7)
  (println  "What is this: " (+ x x))
  (prn "What is this:" (+ x x))
  (println (+ 7654 1234))
  (println (/ (+ (+ 7  (* 3  4)) 5) 10))
  (doc rem)
  (doc mod)
  (println (rem -13 5))
  (println (mod -13 5))
  (find-doc "stack trace"))
