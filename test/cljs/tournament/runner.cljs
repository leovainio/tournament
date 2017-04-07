(ns tournament.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [tournament.core-test]))

(doo-tests 'tournament.core-test)
