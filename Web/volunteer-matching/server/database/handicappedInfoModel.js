const mongoose = require('mongoose');
const Schema = mongoose.Schema;

//스키마 만들기
var managerSchema = new mongoose.Schema({
  userType: Number,
  userID: String,
  userPWD: String,
  userName: String,
  userPhoneNum: String,
  ID_Num: String,
  handicappedNum: String,
  userJob: String,
  userAddr: String,
  userEmail_before: String,
  userEmail_after: String,
  userVolCareer: String,
  userFeedbackVal:Number
});
var ManagerInfo = mongoose.model('ManagerInfo', managerSchema);
module.exports = ManagerInfo;
