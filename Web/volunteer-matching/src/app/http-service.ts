import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class HttpService {
  constructor(private http: HttpClient) {}
  getTest() {
      return this.http.get('/test/testGET?test=test get request from angular');
  }
  postTest() {
    return this.http.post('/test/testPOST',{test: 'test post request from angular'});
  }
}
