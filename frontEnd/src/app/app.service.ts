import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'

const endpoint = 'http://localhost:8080/';
@Injectable({
  providedIn: 'root'
})
export class AppService {

	authenticated = false;

  	constructor(private http: HttpClient) { 
  	}

  	/*authenticate(credentials, callback){

  		const headers = new HttpHeaders(credentials ? {
  			athorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
  		} : {});

  		this.http.get('user', {headers: headers}).subscribe(response => {
  			if(response['name']) {
  				this.authenticated = true
  			} else {
  				this.authenticated = false;
  			}
  			return callback && callback();
  		})
  	}*/

  	authenticate(credentials, callback) {

  		const headers = new HttpHeaders(credentials ? {
  			athorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
  		} : {});

  		this.http.post(endpoint+"login", {headers: headers}).subscribe(response => {
  			if(response['name']) {
  				this.authenticated = true
  			} else {
  				this.authenticated = false;
  			}
  			return callback && callback();
  		});
  	}
}
