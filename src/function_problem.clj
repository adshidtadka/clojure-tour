(ns function-problem)

(require '[clojure.repl :refer :all])

;; (defn greet [] (println "Hello"))
;; (def greet (fn [] (println "Hello")))
(def greet #(println "Hello"))

(defn greeting
  ([] "Hello, World!")
  ([x] (str "Hello, " x "!"))
  ([x y] (str x ", " y "!")))

(defn do-nothing [x] x)

(defn always-thing [& _] 100)

(defn make-thingy [x] (fn [& _] (identity x)))

(defn triplicate [f] (((f))))

(defn opposite [f]
  (fn [& args] (not (apply f args))))

(defn http-get [url] (println (.openStream (.URL url))))

(defn -main []
  (greet)
  (doc str)
  (assert (= "Hello, World!" (greeting)))
  (assert (= "Hello, Clojure!" (greeting "Clojure")))
  (assert (= "Good morning, Clojure!" (greeting "Good morning" "Clojure")))
  (do-nothing "Do nothing")
  (source identity)
  (println (always-thing 1 2 3))
  (let [n (rand-int Integer/MAX_VALUE)
        f (make-thingy n)]
    (assert (= n (f)))
    (assert (= n (f 123)))
    (assert (= n (apply f 123 (range)))))
  (source constantly)
  (println)
  (println (triplicate
            (fn [] identity
              (fn [] identity
                (fn [] (identity "Hello"))))))
  (println ((opposite (fn [x y] (and x y))) true false))
  (println (Math/cos Math/PI))
  (println ((fn [x]
              (+ (Math/pow (Math/sin x) 2)
                 (Math/pow (Math/cos x) 2)))
            Math/PI))
  (http-get "https://www.w3.org"))
