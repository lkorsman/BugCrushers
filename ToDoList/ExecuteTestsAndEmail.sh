#!/bin/bash

antCmd="ant junitreport"

if [ $# -eq 0 ]
	then
		numLoops=1
		echo "No command line arguments"
	else
		numLoops=$1

		for ((i=0; i < $numLoops; ++i))
		do
			eval $antCmd

			if grep -Rq "Failure" ./junit/all-tests.html
			then
				echo "Found failures. Email boss."
			else
				echo "No failures."
			fi
		done
fi
