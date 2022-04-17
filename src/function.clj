(ns function)

(:require '[clojure.string])

;; (defn greet [name] (str "Hello, " name))
(def greet (fn [name] (str "Hello, " name)))

(defn messenger
  ([] (messenger "Hello world!"))
  ([msg] (println msg)))

(defn hello [greeting & who]
  (println greeting who))

(defn plotxy [shape first_coords second_coods]
  (println shape first_coords second_coods))
;; (defn plot [shape coords]
;;   (plotxy shape (first coords) (second coords)))
(defn plot [shape coords]
  (apply plotxy shape coords))

;; let
(defn messenger2 [msg]
  (let [a 7
        b 5
        c (clojure.string/capitalize msg)]
    (println a b c)))

;; closure
(defn messenger-builder [greeting]
  (fn [who] (println greeting who)))
(def hello-er (messenger-builder "Hello"))

(defn -main []
  (println (greet ["student" "parents"]))
  (println (messenger))
  (messenger "Hello class!")
  (hello "Hello" "world" " class" "!")
  (fn [message] (println message))
  ((fn [message] (println message)) "Hello world!")
  (println (#(+ 6 %) 100))
  (println (#(+ %1 %2) 1 2))
  (#(println %1 %2 %&) 1 2 3 4 5)
  (println (#(vector %) 5))
  (println (vector 5))
  ;; apply
  (apply hello '(1 2 3 4))
  (apply hello 1 '(2 3 4))
  (apply hello 1 2 '(3 4))
  (apply hello 1 2 3 '(4))
  (plot "square" [12 13])
  ;; let
  (let [x 1 y 2] (+ x y))
  (messenger2  "hoge")
  ;; closure
  (hello-er "world!")
  ;; Java
  (println (String. "foo"))
  (println (let [x (String. "FOO")]
             (println (.toLowerCase x))
             (println (.length x))))
  (println (Math/PI))
  (println (Math/sqrt 25)))
