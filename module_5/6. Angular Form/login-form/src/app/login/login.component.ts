import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  }

  loginForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.pattern("^[a-z][a-z0-9]{0,}@gmail.com$")]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)])
  })

  temp: any

  onSubmit() {
    this.temp = JSON.stringify(this.loginForm.value)
  }
}
