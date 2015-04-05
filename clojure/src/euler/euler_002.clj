(ns euler.euler_002)

(defn fibonacci-seq
  ([]
   (cons 1 (cons 2 (fibonacci-seq 1 2))))
  ([fst sec]
   (cons (+ fst sec) (lazy-seq (fibonacci-seq sec (+ fst sec))))))


(defn solve-euler-002
  []
  (reduce + (filter even? (take-while #(< % 4000000) (fibonacci-seq)))))
