//기존에 학습했던 routes 폴더(서버)
const express = require ('express');
const router = express.Router();
var mongoose = require('mongoose');

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

//스키마 만들기
var managerSchema = new mongoose.Schema({
  userID: String,
  userPWD: String,
  userNAME: String,
  userPhoneNUM: [Number],
  ID_NUM: [Number],
  userJOB: String,
  userADDR: String,
  userEmail_before: String,
  userEmail_after: String,
  userVolCareer: String,
  userFeedbackVal:Number
});
//모델 만들기
var Manager = mongoose.model('Manager',managerSchema);
// POST 요청
router.post('/requestSignUp',function (req,res) {
  Manager.findOne({},function (err,info) {



  })

})

module.exports = router;
