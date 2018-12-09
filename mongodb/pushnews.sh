#!/bin/bash

if [ "$#" -lt 2 ]; then echo "no channel id nor input, bye!"; fi

channel=$1
input=$2

echo "news to be pushed: $input"

curl -v -H "Content-Type: application/json" -X POST  -d "$input" https://api2.scaledrone.com/$channel/notifications/publish
