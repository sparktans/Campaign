import {Injectable} from '@angular/core';
import {Http,Response} from '@angular/http';

@Injectable()
export class UserService{
   // userData:any;
   constructor(private http:Http){
    }
    public getUserDetails(){
        //return this.http.get('https://app.apiary.io/campaignuserinfo/getuserinfo');
           return this.http.get('https://jsonplaceholder.typicode.com/posts'); 
        
       // console.log('Inservice>>>'+this.userData);
    }
}