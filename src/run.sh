#!/usr/bin/env bash

file=$1

find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java com.rokupin.airport_sim.controller.Run "$file"