(ns luminusdonjon.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [luminusdonjon.core-test]))

(doo-tests 'luminusdonjon.core-test)

