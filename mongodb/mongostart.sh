#!/bin/bash

PORT=50000 
DBDIR="dbpath"
RS="rs"
if [ ! -d "$DBDIR" ]; then mkdir -p $DBDIR; fi

mongod --port=$PORT --dbpath=$DBDIR --replSet "$RS"

