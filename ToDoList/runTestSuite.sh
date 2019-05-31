#!/bin/bash

antCmd="ant junitreport"

if [ -f "stdtxt.txt" ]
then
	rm stdtxt.txt
fi

if [ $# -eq 0 ]
then
	echo "No command line arguments"
else
	buildSuite="bash buildTestSuite.sh"
	eval $buildSuite

	NumberLoop=$1
	startTime=$(date)
	for ((i=0; i < $NumberLoop; ++i))
	do
		eval $antCmd >> stdtxt.txt
	done
	endTime=$(date)
	echo "Regression Test Start time: $startTime"
	echo "Regression Test End time: $endTime"

	# Email
	if [ $# -eq 2 ]
	then
		EmailResultsPerson=$2
		if grep -Rq "Failures: 0" stdtxt.txt
			then
				echo "Junit tests PASSED!" | mutt -s "Junit Test Report" $EmailResultsPerson
			else
				echo "Junit tests failed." | mutt -s "Junit Test Report" $EmailResultsPerson
		fi
	fi
fi
