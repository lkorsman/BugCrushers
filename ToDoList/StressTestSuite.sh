#!/bin/bash

if [[ ($# -eq 0) || ($# -eq 1) ]]
	then
		echo "Not enough arguments"
	else
		NumBackGroundProcesses=$1
		NumberLoop=$2
		runTestSuite="bash runTestSuite.sh $NumberLoop"
		echo "run command $runTestSuite"
		startTime=$(date)
		for ((i=0; i < $NumBackGroundProcesses; ++i))
		do
			eval $runTestSuite &
		done
		wait
		echo Done
		endTime=$(date)
		echo "Stress Test Start time: $startTime"
		echo "Stress Test End time: $endTime"

fi
