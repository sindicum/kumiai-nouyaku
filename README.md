### ・著作権の関係で、pdfファイルとrealmデータベースファイルは除いております。
### ・使用に当たっては、app/src/main にassetsディレクトリを作成し、以下の通りファイル配置して下さい
  
  
app/src/main/assets  
├02ch0001.pdf  
├02ch0002.pdf  
├・・・  
・  
・  
・  
├02te0021.pdf  
└default.realm  
  
    
    
### ・realmデータベースは以下のCSVを作成し、Realm Studioでインポートして下さい。
#### // yakuzai_DB.csv の中身 //
id,name,path  
0,アージラン液剤,02fu0001.pdf  
1,アーデント水和剤,02mu0001.pdf  
.  
.  
.  
1345,Ｚボルドー,02ki0304.pdf  
  
  
### ・csv作成は正規表現を使いながらテキストエディタで体裁を整えて下さい。
#### //　正規表現例 //
ya_list\[[0-9]{1,4}\] = New Ya_inlist\(".+?",|"\d+",".+?",|\);
