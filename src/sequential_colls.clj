(ns sequential-colls)

(defn -main []
  (println)
  (println (get ["abc" false 99] 0))
  (println (get ["abc" false 99] 1))
  (println (get ["abc" false 99] 3))
  (println (count [1 2 3]))
  (println (vector 1 2 3))
  (println (conj [1 2 3] 4 5 6))
  (def v [1 2 3])
  (println (conj v 4 5 6))
  (println v)
  (def cards '(10 :ace :jack 9))
  (println cards)
  (println (first cards))
  (println (rest cards))
  (println (conj cards :queen))
  (def stack '(:a :b))
  (println (peek stack))
  (println (pop stack))
  (println)
  (println))