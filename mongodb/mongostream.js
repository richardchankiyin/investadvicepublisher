pwd();
db = db.getSiblingDB('investadviceapp');
const cursor = db.news.watch();
while (!cursor.isExhausted()) {
   if (cursor.hasNext()) {
      doc = cursor.next().fullDocument;
      print("output:" + doc.symbol);
   }
}
