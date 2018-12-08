#!/bin/bash

port=50000
log=mongostreamlog
archive=archive

if [ ! -d archive ]; then mkdir -p archive; fi
if [ -f $log ]; then mv $log $archive/${log}_$(date +%Y%m%d%H%M%s); fi

mongo --port $port mongostream.js > $log 

