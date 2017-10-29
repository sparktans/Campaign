import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {UserService} from '../../shared/services/user.service';
import {CamPaignCreation} from '../../shared/services/campaigncreation.service';


@Component({
    selector: 'app-form',
    templateUrl: './form.component.html',
    styleUrls: ['./form.component.scss'],
    animations: [routerTransition()],
    providers:[CamPaignCreation,UserService]
})
export class FormComponent implements OnInit {
    rForm: FormGroup;
    userDetails:any;
    groups:any;
     streams:any;
      model: any;
       post:any;                     // A property for our submitted form
  description:string = '';
  name:string = '';
    constructor(private fb: FormBuilder,
                private user:UserService,
                private campaigncreation:CamPaignCreation) {
      console.log('User Details>>>>>constructor111');

    this.rForm = fb.group({
      'name': [null, Validators.required],
      'description': [null, Validators.compose([Validators.required, Validators.minLength(30), Validators.maxLength(500)])],
    
    });

  }
    ngOnInit() {
      console.log('User Details>>>>>1151');
     this.userDetails= this.user.getUserDetails().subscribe(res =>this.userDetails=res.json());
     this.groups= this.campaigncreation.getGroups().subscribe(res =>this.groups=res.json());
     this.streams= this.campaigncreation.getStreams().subscribe(res =>this.streams=res.json());
      //this.userDetails=this.user.userData;

console.log('User Details>>>>>'+this.userDetails);   
console.log('User Details>>>>>'+this.groups.id);    
    }
    saveCampaign(){
      console.log('Submitted....');
      console.log(this.rForm);

    }
     addPost(post) {
    this.description = post.description;
    this.name = post.name;
    console.log('Description'+this.description);
  }
}
