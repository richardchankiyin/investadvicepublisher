#!/bin/bash
if [ ! -f channelid ]; then echo "no scaledrone channel id file"; exit -1; fi
channel=$(cat channelid)
log=mongostreamlog
tail -0f $log | xargs -I {} ./pushnews.sh $channel "{}" 
