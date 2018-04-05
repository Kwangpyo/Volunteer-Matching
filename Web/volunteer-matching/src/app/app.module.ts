import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

// 어플리케이션 내에서 해당 모듈을 사용할 수 있도록 import
import { HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { HttpService} from './http-service';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule // imports에 추가
  ],
  providers: [HttpService], // 컴포넌트들이 서비스를 사용할 수 있도록 providers에 추가
  bootstrap: [AppComponent]
})
export class AppModule { }
