#!/bin/bash
log=mongostreamlog
tail -0f $log | xargs -I {} ./pushnews.sh "{}"
