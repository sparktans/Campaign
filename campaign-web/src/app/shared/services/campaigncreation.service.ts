import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

@Injectable()
export class CamPaignCreation {
    constructor(private http:Http){

    }
    getGroups(){
        return this.http.get('https://jsonplaceholder.typicode.com/posts');
    }
    getStreams(){
        return this.http.get('https://jsonplaceholder.typicode.com/posts');
    }
}