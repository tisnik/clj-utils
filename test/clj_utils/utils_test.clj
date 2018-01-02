;
;  (C) Copyright 2017  Pavel Tisnovsky
;
;  All rights reserved. This program and the accompanying materials
;  are made available under the terms of the Eclipse Public License v1.0
;  which accompanies this distribution, and is available at
;  http://www.eclipse.org/legal/epl-v10.html
;
;  Contributors:
;      Pavel Tisnovsky
;

(ns clj-utils.utils-test
  (:require [clojure.test :refer :all]
            [clj-utils.utils :refer :all]))

;
; Common functions used by tests.
;

(defn callable?
    "Test if given function-name is bound to the real function."
    [function-name]
    (clojure.test/function? function-name))

;
; Tests for functions existence
;

(deftest test-third-existence
    "Check that the clj-utils.utils/third definition exists."
    (testing "if the clj-utils.utils/third definition exists."
        (is (callable? 'clj-utils.utils/third))))


(deftest test-fourth-existence
    "Check that the clj-utils.utils/fourth definition exists."
    (testing "if the clj-utils.utils/fourth definition exists."
        (is (callable? 'clj-utils.utils/fourth))))


(deftest test-substring-existence
    "Check that the clj-utils.utils/substring definition exists."
    (testing "if the clj-utils.utils/substring definition exists."
        (is (callable? 'clj-utils.utils/substring))))


(deftest test-startsWith-existence
    "Check that the clj-utils.utils/startsWith definition exists."
    (testing "if the clj-utils.utils/startsWith definition exists."
        (is (callable? 'clj-utils.utils/startsWith))))


(deftest test-endsWith-existence
    "Check that the clj-utils.utils/endsWith definition exists."
    (testing "if the clj-utils.utils/endsWith definition exists."
        (is (callable? 'clj-utils.utils/endsWith))))


(deftest test-contains-existence
    "Check that the clj-utils.utils/contains definition exists."
    (testing "if the clj-utils.utils/contains definition exists."
        (is (callable? 'clj-utils.utils/contains))))


(deftest test-replaceAll-existence
    "Check that the clj-utils.utils/replaceAll definition exists."
    (testing "if the clj-utils.utils/replaceAll definition exists."
        (is (callable? 'clj-utils.utils/replaceAll))))


(deftest test-get-exception-message-existence
    "Check that the clj-utils.utils/get-exception-message definition exists."
    (testing "if the clj-utils.utils/get-exception-message definition exists."
        (is (callable? 'clj-utils.utils/get-exception-message))))


(deftest test-throw-exception-existence
    "Check that the clj-utils.utils/throw-exception definition exists."
    (testing "if the clj-utils.utils/throw-exception definition exists."
        (is (callable? 'clj-utils.utils/throw-exception))))


(deftest test-parse-int-existence
    "Check that the clj-utils.utils/parse-int definition exists."
    (testing "if the clj-utils.utils/parse-int definition exists."
        (is (callable? 'clj-utils.utils/parse-int))))


(deftest test-parse-float-existence
    "Check that the clj-utils.utils/parse-float definition exists."
    (testing "if the clj-utils.utils/parse-float definition exists."
        (is (callable? 'clj-utils.utils/parse-float))))


(deftest test-parse-boolean-existence
    "Check that the clj-utils.utils/parse-boolean definition exists."
    (testing "if the clj-utils.utils/parse-boolean definition exists."
        (is (callable? 'clj-utils.utils/parse-boolean))))



;
; Tests for behaviour of all functions
;

(deftest test-get-exception-message-1
    "Check the function clj-utils.utils/get-exception-message."
    (testing "the function clj-utils.utils/get-exception-message."
        (try
            (throw (new java.lang.Exception "Message text"))
            (is nil "Exception not thrown as expected!")
            (catch Exception e
                (is (= "Message text" (get-exception-message e)))))))

(deftest test-get-exception-message-2
    "Check the function clj-utils.utils/get-exception-message."
    (testing "the function clj-utils.utils/get-exception-message."
        (try
            (/ 1 0)
            (is nil "Exception not thrown as expected!")
            (catch Exception e
                (is (= "Divide by zero" (get-exception-message e)))))))

(deftest test-get-exception-message-3
    "Check the function clj-utils.utils/get-exception-message."
    (testing "the function clj-utils.utils/get-exception-message."
        (try
            (Integer/parseInt "unparseable")
            (is nil "Exception not thrown as expected!")
            (catch Exception e
                (is (.startsWith (get-exception-message e) "For input string:"))))))

(deftest test-get-exception-message-4
    "Check the function clj-utils.utils/get-exception-message."
    (testing "the function clj-utils.utils/get-exception-message."
        (try
            (throw (new java.lang.Exception ""))
            (is nil "Exception not thrown as expected!")
            (catch Exception e
                (is (= "" (get-exception-message e)))))))

(deftest test-get-exception-message-5
    "Check the function clj-utils.utils/get-exception-message."
    (testing "the function clj-utils.utils/get-exception-message."
        (try
            (throw (new java.lang.Exception))
            (is nil "Exception not thrown as expected!")
            (catch Exception e
                (is (nil? (get-exception-message e)))))))

(deftest test-get-exception-message-6
    "Check the function clj-utils.utils/get-exception-message."
    (testing "the function clj-utils.utils/get-exception-message."
        (try
            (println (nth [] 10)) ; realize the sequence and getter
            (is nil "Exception not thrown as expected!")
            (catch Exception e
                (is (nil? (get-exception-message e)))))))

(deftest test-third-1
    "Check the function clj-utils.utils/third."
    (testing "the function clj-utils.utils/third."
        (are [x y] (= x y)
            3 (third [1 2 3])
            3 (third [1 2 3 4 5])
            3 (third '(1 2 3))
            3 (third '(1 2 3 4 5)))))

(deftest test-third-2
    "Check the function clj-utils.utils/third."
    (testing "the function clj-utils.utils/third."
        (are [x y] (= x y)
            nil (third [])
            nil (third '())
            nil (third [1])
            nil (third '(1))
            nil (third [1 2])
            nil (third '(1 2)))))

(deftest test-third-not-NPE
    "Check the function clj-utils.utils/third."
    (testing "the function clj-utils.utils/third."
        (are [x y] (= x y)
            nil (third nil))))

(deftest test-fourth-1
    "Check the function clj-utils/fourth."
    (testing "the function clj-utils/fourth."
        (are [x y] (= x y)
            4 (fourth [1 2 3 4 5])
            4 (fourth '(1 2 3 4))
            4 (fourth '(1 2 3 4 5)))))

(deftest test-fourth-2
    "Check the function clj-utils/fourth."
    (testing "the function clj-utils/fourth."
        (are [x y] (= x y)
            nil (fourth [])
            nil (fourth '())
            nil (fourth [1])
            nil (fourth '(1))
            nil (fourth [1 2])
            nil (fourth '(1 2))
            nil (fourth [1 2 3])
            nil (fourth '(1 2 3)))))

(deftest test-fourth-not-NPE
    "Check the function clj-utils/fourth."
    (testing "the function clj-utils/fourth."
        (are [x y] (= x y)
            nil (fourth nil))))

(deftest test-substring-1
    "Check the function clj-utils.utils/substring."
    (testing "the function clj-utils.utils/substring."
        (are [x y] (= x y)
            "H"      (substring "Hello world!" 0 1)
            "He"     (substring "Hello world!" 0 2)
            "Hello"  (substring "Hello world!" 0 5)
            "Hello " (substring "Hello world!" 0 6))))

(deftest test-substring-2
    "Check the function clj-utils.utils/substring."
    (testing "the function clj-utils.utils/substring."
        (are [x y] (= x y)
            "w"      (substring "Hello world!" 6 7)
            "wo"     (substring "Hello world!" 6 8)
            "world"  (substring "Hello world!" 6 11)
            "world!" (substring "Hello world!" 6 12))))

(deftest test-substring-3
    "Check the function clj-utils.utils/substring."
    (testing "the function clj-utils.utils/substring."
        (are [x y] (= x y)
            "Hello world!" (substring "Hello world!" 0)
            "ello world!"  (substring "Hello world!" 1)
            "world!"       (substring "Hello world!" 6)
            "!"            (substring "Hello world!" 11)
            ""             (substring "Hello world!" 12))))

(deftest test-substring-empty-result
    "Check the function clj-utils.utils/substring."
    (testing "the function clj-utils.utils/substring."
        (are [x y] (= x y)
            "" (substring "Hello world!" 0 0)
            "" (substring "Hello world!" 1 1)
            "" (substring "Hello world!" 2 2)
            "" (substring "Hello world!" 10 10))))

(deftest test-substring-NPE
    "Check the function clj-utils.utils/substring."
    (testing "the function clj-utils.utils/substring."
        (is (thrown? NullPointerException (substring nil 0 0)))
        (is (thrown? NullPointerException (substring "" nil 0)))
        (is (thrown? NullPointerException (substring "" 0 nil)))))

(deftest test-contains-1
    "Check the function clj-utils.utils/contains."
    (testing "the function clj-utils.utils/contains."
        (are [x y] (= x y)
            false (contains "Hello world!" "h")
            true  (contains "Hello world!" "H")
            true  (contains "Hello world!" " ")
            true  (contains "Hello world!" "!"))))

(deftest test-contains-2
    "Check the function clj-utils.utils/contains."
    (testing "the function clj-utils.utils/contains."
        (are [x y] (= x y)
            false (contains "Hello world!" "hello")
            true  (contains "Hello world!" "Hello")
            true  (contains "Hello world!" "o w")
            true  (contains "Hello world!" "world!"))))

(deftest test-contains-NPE
    "Check the function clj-utils.utils/contains."
    (testing "the function clj-utils.utils/contains."
        (is (thrown? NullPointerException (contains nil "")))
        (is (thrown? NullPointerException (contains "" nil)))
        (is (thrown? NullPointerException (contains nil nil)))))

(deftest test-startsWith-1
    "Check the function clj-utils.utils/startsWith."
    (testing "the function clj-utils.utils/startsWith."
        (are [x y] (= x y)
            false (startsWith "Hello world!" "hello")
            true  (startsWith "Hello world!" "Hello")
            true  (startsWith "Hello world!" "H")
            true  (startsWith "Hello world!" ""))))

(deftest test-startsWith-2
    "Check the function clj-utils.utils/startsWith."
    (testing "the function clj-utils.utils/startsWith."
        (are [x y] (= x y)
            false (startsWith "" "hello")
            false (startsWith "" "Hello")
            false (startsWith "" "H")
            true  (startsWith "" ""))))

(deftest test-startsWith-NPE
    "Check the function clj-utils.utils/startsWith."
    (testing "the function clj-utils.utils/startsWith."
        (is (thrown? NullPointerException (startsWith nil nil)))
        (is (thrown? NullPointerException (startsWith "text" nil)))
        (is (thrown? NullPointerException (startsWith nil "text")))))

(deftest test-starts-with-1
    "Check the function clj-utils.utils/starts-with."
    (testing "the function clj-utils.utils/starts-with."
        (are [x y] (= x y)
            false (starts-with "Hello world!" "hello")
            true  (starts-with "Hello world!" "Hello")
            true  (starts-with "Hello world!" "H")
            true  (starts-with "Hello world!" ""))))

(deftest test-starts-with-2
    "Check the function clj-utils.utils/starts-with."
    (testing "the function clj-utils.utils/starts-with."
        (are [x y] (= x y)
            false (starts-with "" "hello")
            false (starts-with "" "Hello")
            false (starts-with "" "H")
            true  (starts-with "" ""))))

(deftest test-starts-with-NPE
    "Check the function clj-utils.utils/starts-with."
    (testing "the function clj-utils.utils/starts-with."
        (is (thrown? NullPointerException (starts-with nil nil)))
        (is (thrown? NullPointerException (starts-with "text" nil)))
        (is (thrown? NullPointerException (starts-with nil "text")))))

(deftest test-ends-with-1 "Check the function clj-utils.utils/ends-with."
    (testing "the function clj-utils.utils/ends-with."
        (are [x y] (= x y)
            true  (endsWith "Hello world!" "Hello world!")
            false (endsWith "Hello world!" "hello world!")
            true  (endsWith "Hello world!" "world!")
            true  (endsWith "Hello world!" "!")
            true  (endsWith "Hello world!" ""))))

(deftest test-ends-with-2
    "Check the function clj-utils.utils/ends-with."
    (testing "the function clj-utils.utils/ends-with."
        (are [x y] (= x y)
            false (endsWith "" "hello")
            false (endsWith "" "Hello")
            false (endsWith "" "H")
            true  (endsWith "" ""))))

(deftest test-ends-with-NPE
    "Check the function clj-utils.utils/ends-with."
    (testing "the function clj-utils.utils/ends-with."
        (is (thrown? NullPointerException (endsWith nil nil)))
        (is (thrown? NullPointerException (endsWith "text" nil)))
        (is (thrown? NullPointerException (endsWith nil "text")))))

(deftest test-replaceAll-1
    "Check the function clj-utils.utils/replaceAll."
    (testing "the function clj-utils.utils/replaceAll."
        (are [x y] (= x y)
            ""    (replaceAll "" "" "")
            "b"   (replaceAll "a" "a" "b")
            "bb"  (replaceAll "aa" "a" "b")
            "bcb" (replaceAll "aca" "a" "b"))))

(deftest test-replaceAll-2
    "Check the function clj-utils.utils/replaceAll."
    (testing "the function clj-utils.utils/replaceAll."
        (are [x y] (= x y)
            "b"     (replaceAll "aa" "aa" "b")
            "bb"    (replaceAll "aaaa" "aa" "b")
            "xbbx"  (replaceAll "xaaaax" "aa" "b")
            "xbxbx" (replaceAll "xaaxaax" "aa" "b"))))

(deftest test-replaceAll-not-NPE
    "Check the function clj-utils.utils/replaceAll."
    (testing "the function clj-utils.utils/replaceAll."
        (is (= "a" (replaceAll "a" "b" nil)))))

(deftest test-replaceAll-NPE
    "Check the function clj-utils.utils/replaceAll."
    (testing "the function clj-utils.utils/replaceAll."
        (is (thrown? NullPointerException (replaceAll nil "a" "b")))
        (is (thrown? NullPointerException (replaceAll "a" nil "b")))
        (is (thrown? NullPointerException (replaceAll "a" "a" nil)))
        (is (thrown? NullPointerException (replaceAll nil nil "b")))))

(deftest test-parse-boolean
    "Check the behaviour of function clj-utils.config/parse-boolean."
    (are [x y] (= x y)
        true (parse-boolean "true")
        true (parse-boolean "True")
        false (parse-boolean "false")
        false (parse-boolean "False")
        false (parse-boolean "")
        false (parse-boolean "unknown")
        false (parse-boolean nil)))

(deftest test-parse-int-zero
    "Check the behaviour of function clj-utils.config/parse-int."
    (are [x y] (== x y)
        0 (parse-int "0")
        0 (parse-int "00")
        0 (parse-int "000")
        0 (parse-int "-0")
        0 (parse-int "-00")
        0 (parse-int "-000")))

(deftest test-parse-int-positive-int
    "Check the behaviour of function clj-utils.config/parse-int."
    (are [x y] (== x y)
        1          (parse-int "1")
        2          (parse-int "2")
        42         (parse-int "42")
        65535      (parse-int "65535")
        65536      (parse-int "65536")
        2147483646 (parse-int "2147483646")))

(deftest test-parse-int-negative-int
    "Check the behaviour of function clj-utils.config/parse-int."
    (are [x y] (== x y)
        -1          (parse-int "-1")
        -2          (parse-int "-2")
        -42         (parse-int "-42")
        -65535      (parse-int "-65535")
        -65536      (parse-int "-65536")
        -2147483647 (parse-int "-2147483647")))

(deftest test-parse-int-min-int
    "Check the behaviour of function clj-utils.config/parse-int."
    (is (== Integer/MIN_VALUE (parse-int "-2147483648"))))

(deftest test-parse-int-max-int
    "Check the behaviour of function clj-utils.config/parse-int."
    (is (== Integer/MAX_VALUE (parse-int "2147483647"))))

(deftest test-parse-int-overflow
    "Check the behaviour of function clj-utils.config/parse-int."
    (are [x] (thrown? NumberFormatException x)
        (parse-int "2147483648")
        (parse-int "-2147483649")))

(deftest test-parse-int-bad-input
    "Check the behaviour of function clj-utils.config/parse-int."
    (are [x] (thrown? NumberFormatException x)
        (parse-int "")
        (parse-int " ")
        (parse-int "xyzzy")))
       ; (parse-int "+1"))) ; removed, not compatible with all supported JDKs

(deftest test-parse-float-zero
    "Check the behaviour of function clj-utils.config/parse-float."
    (are [x y] (== x y)
        0.0 (parse-float "0")
        0.0 (parse-float "00")
        0.0 (parse-float "000")
        0.0 (parse-float "-0")
        0.0 (parse-float "-00")
        0.0 (parse-float "-000")))

(deftest test-parse-float-positive-values
    "Check the behaviour of function clj-utils.config/parse-float."
    (are [x y] (== x y)
        0.5 (parse-float "0.5")
        1.0 (parse-float "1.0")
        1.5 (parse-float "1.5")
        2.0 (parse-float "2")
        1000.0 (parse-float "1000")
        10000.0 (parse-float "10000")
        1e10 (parse-float "10000000000")
        1e10 (parse-float "1e10")))

(deftest test-parse-float-negative-values
    "Check the behaviour of function clj-utils.config/parse-float."
    (are [x y] (== x y)
        -0.5 (parse-float "-0.5")
        -1.0 (parse-float "-1.0")
        -1.5 (parse-float "-1.5")
        -2.0 (parse-float "-2")
        -1000.0 (parse-float "-1000")
        -10000.0 (parse-float "-10000")
        -1e10 (parse-float "-10000000000")
        -1e10 (parse-float "-1e10")))

(deftest test-parse-float-min-value
    "Check the behaviour of function clj-utils.config/parse-int."
    (is (== Float/MIN_VALUE (parse-float "0x0.000002P-126f"))))

(deftest test-parse-float-max-value
    "Check the behaviour of function clj-utils.config/parse-int."
    (is (== Float/MAX_VALUE (parse-float "0x1.fffffeP+127f"))))

(deftest test-parse-float-bad-input
    "Check the behaviour of function clj-utils.config/parse-float."
    (are [x] (thrown? NumberFormatException x)
        (parse-float "")
        (parse-float "xyzzy")
        (parse-float "-1xyzzy")))

(deftest test-throw-exception
    "Check the behaviour of function clj-utils.utils/throw-exception."
    (are [x] (thrown? Exception x)
        (throw-exception "")
        (throw-exception "message")
        (throw-exception "prefix" (new Exception "message"))))
