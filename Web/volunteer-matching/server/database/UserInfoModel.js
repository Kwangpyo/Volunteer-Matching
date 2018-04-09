const mongoose = require('mongoose');

//스키마 만들기
var userSchema = new mongoose.Schema({
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
var UserInfo = mongoose.model('UserInfo', userSchema);
module.exports = UserInfo;
