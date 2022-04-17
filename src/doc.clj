(ns doc)

(require '[clojure.repl :refer :all])

(defn -main []
  (doc +)
  (doc doc)
  (apropos "+")
  (find-doc "trim")
  (dir clojure.repl)
  (source dir))
