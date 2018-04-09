//기존에 학습했던 routes 폴더(서버)
const express = require ('express');
const router = express.Router();
var mongoose = require('mongoose');
const UserInfo = require('../database/UserInfoModel');


mongoose.Promise = global.Promise
mongoose.connect('mongodb://localhost/test');
var db = mongoose.connection;

db.on('error', function(err) {
  console.log("error: " + err);
});

db.on('connected', function() {
  console.log("Connected successfully to server");
});

router.get('/',function(req,res){
  res.send('express works');
});

router.get('/testGET',function(req,res){
  console.log(req.query.test);
  res.send({test : 'response data from GET handler'});
});

router.post('/testPOST',function(req,res){
  console.log(req.body.test);
  res.send({test : 'response data from POST handler'});
});

router.get('/view',function (req,res) {
  UserInfo.find(function (err,info) {
    console.log('info is '+info);
  })
});

router.get('/app/requestSignUp/:id',function (req,res) {
  var id = req.params.id;
  var pwd = req.query.pwd;
  var userType = req.query.type;
  var userName = req.query.name;
  var phoneNum = req.query.phone;
  var idNum = req.query.idnum;
  var handicappedNum = req.query.hnum;
  //var userJob

  console.log("id is"+id);
  console.log("pwd is"+pwd);

  UserInfo.findOne({userID: id},function (err,info) {
    var isValid = {boolean: false};
    if(err){
      return console.log("err :"+err);
    }
    if(info){//이미 존재하는 ID
      console.log('아이디 중복: '+info.userID);
      //res.send(isValid);
    }
    else {//존재하지 않는 ID
      var newUser = new UserInfo();
      newUser.userID = id;
      //managerInfo.~생략

      newUser.save(function (err, document) {
        if (err) {
          return console.log("err :" + err);
        }
        isVaild = {boolean: true};
        //res.send(isValid);
        console.log('아이디 생성 완료: ' + document);
      });
    }
  });
});

router.get('/app/requestSignUp/:id',function (req,res) {

});


module.exports = router;
