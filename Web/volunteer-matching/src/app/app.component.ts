// ngOnInit 함수를 사용하기 위해 OnInit도 함께 import
import { Component, OnInit } from '@angular/core';
// HttpService 를 사용하기 위해 import
import {HttpService} from './http-service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  // httpService 변수에 HttpService를 의존성 주입
  constructor(private httpService: HttpService) {}

  ngOnInit(){
    this.getDataFromGET();
    this.getDataFromPOST();
  }
  getDataFromGET(): any {
    this.httpService.getTest().subscribe(result =>
      console.log(result));
  }
  getDataFromPOST(): any {
    return this.httpService.postTest().subscribe(result =>
      console.log(result));
  }
}
