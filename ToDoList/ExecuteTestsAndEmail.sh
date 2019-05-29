#!/bin/bash

OUTFILE="stdout.txt"
antCmd="ant ToDoElementStructTest"

if [ $# -eq 0 ]
	then
		numLoops=1
		echo "No command line arguments"
	else
		numLoops=$1

		for ((i=0; i < $numLoops; ++i))
		do
			eval $antCmd > $OUTFILE

			if grep -R "Failures: 0" $OUTFILE
			then
				echo "No failures."
			else
				echo "Email the boss."
			fi
		done
fi
