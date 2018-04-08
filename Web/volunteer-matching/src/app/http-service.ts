import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class HttpService {
  constructor(private http: HttpClient) {}
  getTest() {
      return this.http.get('/testGET?test=test get request from angular');
  }
  postTest() {
    return this.http.post('/testPOST',{test: 'test post request from angular'});
  }
}
