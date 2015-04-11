(ns euler.euler_003)

(defn prime?
  ([n prime-list]
   (empty? (filter #(zero? (mod n %)) (take-while #(>= (Math/sqrt n) %) prime-list))))
  ([n]
   (empty? (filter #(zero? (mod n %)) (range 2 (inc (int (Math/sqrt n))))))))

(defn next-prime
  [prev-prime]
  (first (filter prime? (drop (inc prev-prime) (range)))))

(defn prime-seq
  ([prev-prime]
   (let [next (next-prime prev-prime)]
     (cons next (lazy-seq (prime-seq next)))))
  ([]
   (cons 2 (lazy-seq (prime-seq 2)))))

(defn prime-factor
  [n]
  (if (prime? n)
    (list n)
    (let [next-factor (first (filter #(zero? (mod n %)) (prime-seq)))]
      (cons next-factor (lazy-seq (prime-factor (/ n next-factor)))))))

(defn solve-euler-003
  []
  (reduce max (prime-factor 600851475143)))
