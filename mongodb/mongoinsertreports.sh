#!/bin/bash

port=50000

symbolseq=$1
if [ "$#" -lt 1 ];then symbolseq=1; fi
seq=$(date +%Y%m%d%H%M%s)

mongo --port $port --eval "db=db.getSiblingDB('investadviceapp');db.report.insert({'symbol':'symbol$symbolseq','id':'report$seq','type':'news', 'detail': {'title':'Firm XXX records profit growth 50% in YoY', 'source':'YYY news', 'content':'Firm XXX annonces a strong year on year growth. This result performs better than analyst expectation'  }});"

mongo --port $port --eval "db=db.getSiblingDB('investadviceapp');db.news.insert({'symbol':'symbol$symbolseq', 'summary':'Firm XXX records profit growth 50% in YoY', 'reportid':'report$seq', 'time':ISODate()});"

sleep 5;

seq=$(date +%Y%m%d%H%M%s)
mongo --port $port --eval "db=db.getSiblingDB('investadviceapp');db.report.insert({'symbol':'symbol$symbolseq','id':'report$seq','type':'research', 'detail':{'title':'Investment Bank ZZZ upgrades Firm XXX from buy to strong buy', 'author':'Mr AAA','content':'Firm XXX shows very strong profit growth in this year and this forms a strong trend in upcoming next couple years.'}});"

mongo --port $port --eval "db=db.getSiblingDB('investadviceapp');db.news.insert({'symbol':'symbol$symbolseq','summary':'Investment Bank ZZZ upgrades Firm XXX from buy to strong buy ', 'reportid':'report$seq', 'time':ISODate()});"
