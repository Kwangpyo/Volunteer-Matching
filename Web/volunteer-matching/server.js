const  express = require('express');
const  path = require('path');
const http = require('http');
const bodyParser = require('body-parser');


// 테스트용 라우트
const test = require('./server/routes/main');

// 수강신청 라우트 && 시간표조회 라우트
//const doajou = require('./server/routes/doAjou');

// db 라우트
//const datebase = require('./server/database/clientInfoModel');

const app = express();

//POST 데이터 파싱 설정
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended : false}));

//ng build 명령 실행시 생성되는 static 리소스 폴더 경로 및 이름 설정
app.use(express.static(path.join(__dirname,'dist')));

//session 설정
/*app.use(session({
  secret : 'dsdfsdfwerwer!!!sdfsdfs', // session id 보안 아무값이나 넣어도된다.
  resave: false, //session Id를 접속할때마다 새로발급을 하지 말라
  saveUnintialized: true //session을 사용하기전까지는 발급을 하지말라
}));*/

//test.js를 'localhost:3000/test' 에 대한 라우터로 설정
app.use('/',test);


//모든 경로에 대한 라우터 설정 및 반환 파일 경로 설정
app.get('*',function(req,res){
  res.sendFile(path.join(__dirname,'dist/index.html'));
});

//Port 설정
const port = process.env.PORT || '3000';
app.set('port',port);

//HTTP 서버 생성
const server = http.createServer(app);
//설정된 포트로 서버가 요청 대기
server.listen(port,function(){
  console.log('Express run on localhost'+port);
});

module.export = server;
