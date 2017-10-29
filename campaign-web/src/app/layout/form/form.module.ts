import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { HttpModule } from '@angular/http';

import { FormRoutingModule } from './form-routing.module';
import { FormComponent } from './form.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
    
    imports: [
        CommonModule,
        FormRoutingModule,
        FormsModule,
        HttpModule,
        ReactiveFormsModule
        
        
    ],
    declarations: [FormComponent]
})
export class FormModule { }
