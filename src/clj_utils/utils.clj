;
;  (C) Copyright 2017, 2018  Pavel Tisnovsky
;
;  All rights reserved. This program and the accompanying materials
;  are made available under the terms of the Eclipse Public License v1.0
;  which accompanies this distribution, and is available at
;  http://www.eclipse.org/legal/epl-v10.html
;
;  Contributors:
;      Pavel Tisnovsky
;


(ns clj-utils.utils
    "Various utility functions used by other modules.")


(defn third
    "Simple utility function - returns third item from a given sequence, nil if third item does not exist."
    [coll]
    (nth coll 2 nil))


(defn fourth
    "Simple utility function - returns fourth item from a given sequence, nil if third item does not exist."
    [coll]
    (nth coll 3 nil))


(defn substring
    "Call method String.substring()."
    ([^String s from to]
     (.substring s from to))
    ([^String s from]
     (.substring s from)))


(defn startsWith
    "Call method String.startsWith()."
    [^String s pattern]
    (.startsWith s pattern))


(defmacro starts-with
    [s pattern]
    `(startsWith ~s ~pattern))


(defn endsWith
    "Call method String.endsWith()."
    [^String s pattern]
    (.endsWith s pattern))


(defmacro ends-with
    [s pattern]
    `(endsWith ~s ~pattern))


(defn contains
    "Call method String.contains()."
    [^String s pattern]
    (.contains s pattern))


(defn replaceAll
    "Call method String.replaceAll()."
    [^String s pattern replacement]
    (.replaceAll s pattern replacement))


(defmacro replace-all
    [s pattern replacement]
    `(replaceAll ~s ~pattern ~replacement))


(defn get-exception-message
    "Retrieve a message from given exception."
    [^java.lang.Exception exception]
    (.getMessage exception))


(defn parse-int
    "Parse the given string as an integer number."
    [^String string]
    (java.lang.Integer/parseInt string))


(defmacro ->int
    [s]
    `(parse-int ~s))


(defn parse-float
    "Parse the given string as a float number."
    [^String string]
    (java.lang.Float/parseFloat string))


(defmacro ->float
    [s]
    `(parse-float ~s))


(defn parse-boolean
    "Parse the given string as a boolean value."
    [^String string]
    (or (= string "true")
        (= string "True")
        (= string "yes")
        (= string "Yes")))


(defmacro ->boolean
    [s]
    `(parse-boolean ~s))


(defn parse-color
    "Parse the value in format #rrggbb and return red, green, blue triple; nil instead."
    [^String string]
    (if (and string (re-matches #"#[0-9a-fA-F]{6}" string))
        (let [red-part   (subs string 1 3)
              green-part (subs string 3 5)
              blue-part  (subs string 5 7)]
              ; parsing must be successful, because the string matched HTML color regexp
              [(Integer/parseInt red-part   16)
               (Integer/parseInt green-part 16)
               (Integer/parseInt blue-part  16)])))


(defn parse-color->Color
    "Conversion from color triple (vector) into an instance java.awt.Color."
    [^String string]
    (let [color-triple (parse-color string)]
        (if color-triple
            (new java.awt.Color (first color-triple)
                                (second color-triple)
                                (third color-triple)))))


(defn rgb->Color
    "Convert a RGB vector into color"
    [rgb]
        (apply #(java.awt.Color. %1 %2 %3) rgb))


(defn throw-exception
    ( [message]
      (throw (new Exception message)))
    ( [message previous-exception]
      (throw (new Exception (str message (.getMessage previous-exception))))))

