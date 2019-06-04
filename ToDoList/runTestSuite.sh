#!/bin/bash

antCmd="ant junitreport"

if [ $# -eq 0 ]
then
	echo "No command line arguments"
else
	buildSuite="bash buildTestSuite.sh"
	eval $buildSuite

	if [ -f "stdtxt.txt" ]
	then
		rm stdtxt.txt
	fi

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
				echo "Junit tests PASSED!" | mutt -s "PASS" $EmailResultsPerson -a ./junit/all-tests.html
			else
				echo "Junit tests failed." | mutt -s "FAIL" $EmailResultsPerson -a ./junit/all-tests.html
		fi
	fi
fi
