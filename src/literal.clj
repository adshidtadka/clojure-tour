(ns literal)

(defn -main []
  (println 42)
  (println -1.5)
  (println 22/7)
  (println ##Inf)
  (println ##NaN)
  (println 22/7)
  (println "hello")
  (println \e)
  (println #"[0-9]+")
  (println map)
  (println +)
  (println clojure.core/+)
  (println nil)
  (println :alpha)
  (println :release/alpha)
  (println true)
  (println '(1 2 3))
  (println [1 2 3])
  (println #{1 2 3})
  (println {:a 1, :b 2}))
