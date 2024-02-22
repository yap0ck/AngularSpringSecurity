import {Component, OnDestroy, OnInit} from '@angular/core';
import {UserService} from "../service/user.service";
import {Subject, takeUntil} from "rxjs";
import {Auth} from "../models/Auth";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnDestroy, OnInit{
  form!: FormGroup
  auth!: Auth
  $destroyed = new Subject<boolean>();
  constructor(private _formBuilder: FormBuilder, private readonly _userService: UserService, private router:Router) {
    this.form = this._formBuilder.group(({
    login:['', Validators.required],
    password:['', Validators.required]
  }))}
  ngOnInit() {

  }



  login() {
      this._userService.login(this.form).pipe(takeUntil(this.$destroyed)).subscribe({
        next: (value) => {
          this.auth = value
          localStorage.setItem("token", this.auth.token);
          localStorage.setItem("login", this.auth.login);
          let i = 1;
          this.auth.roles.map(r=> {
            localStorage.setItem("role"+i, r)
            i++
          })
        },
        error: (err) => alert(err.message),
        complete: ()=> {
          console.log("Chargement terminé")
          this.router.navigate(['/user/get'])
        }
        }
      );
  }
  ngOnDestroy() {

    this.$destroyed.next(true);
    this.$destroyed.complete();
  }
}
