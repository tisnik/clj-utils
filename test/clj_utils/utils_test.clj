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


