(ns function-problem)

(require '[clojure.repl :refer :all])
(import '(java.net URL))

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

(defn triplicate [f] (f) (f) (f))

(defn opposite [f]
  (fn [& args] (not (apply f args))))

(defn triplicate2 [f & args]
  (triplicate (fn [] (apply f args))))

(defn sincos [x]
  (+ (Math/pow (Math/sin x) 2)
     (Math/pow (Math/cos x) 2)))

(defn http-get [url] (slurp (.openStream (URL. url))))

(defn one-less-arg [f x]
  (fn [& args] (apply f x args)))

(defn two-fns [f g]
  (fn [arg] (f (g arg))))

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
  (println (triplicate greet))
  (println ((opposite (fn [x y] (and x y))) true false))
  (println)
  (println (triplicate2 greeting "Triplicate2"))
  (println)
  (println (Math/cos Math/PI))
  (println)
  (println (sincos Math/PI))
  (println (sincos 899))
  (println)
  (doc slurp)
  (println)
  (assert (.contains (http-get "https://www.w3.org") "html"))
  (println)
  (println ((one-less-arg  greeting "Good morning") "additional-arg"))
  (println)
  (doc partial)
  (println)
  (println ((partial  greeting "Good morning") "additional-arg"))
  (println)
  (println ((two-fns greeting greeting) "two-fns"))
  (println))
