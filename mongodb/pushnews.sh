#!/bin/bash

if [ "$#" -lt 1 ]; then echo "no input, bye!"; fi

input=$1

echo "news to be pushed: $input"

curl -v -H "Content-Type: application/json" -X POST  -d "$input" https://api2.scaledrone.com/jiUv2Rpk1O8tZbZ7/notifications/publish
