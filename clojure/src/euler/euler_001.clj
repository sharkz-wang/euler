(ns euler.euler_001)

(defn sum-of-multiple-of-3-or-5
  [n-list]
  (reduce + (filter #(or (zero? (mod % 5)) (zero? (mod % 3))) n-list)))

(defn solve-euler-001
  []
  (sum-of-multiple-of-3-or-5 (range 1 1000)))
