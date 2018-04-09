const mongoose = require('mongoose');
const Schema = mongoose.Schema;

//스키마 만들기
var managerSchema = new mongoose.Schema({
  userType: Number,
  userID: String,
  userPWD: String,
  userName: String
});
var ManagerInfo = mongoose.model('ManagerInfo', managerSchema);
module.exports = ManagerInfo;
