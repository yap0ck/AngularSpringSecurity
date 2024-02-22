import {Component, OnDestroy, OnInit} from '@angular/core';
import {User} from "../models/User";
import {Subject, takeUntil} from "rxjs";
import {UserService} from "../service/user.service";
import {adminGuard} from "../guard/admin.guard";
import {Router} from "@angular/router";

@Component({
  selector: 'app-get',
  templateUrl: './get.component.html',
  styleUrl: './get.component.css'
})
export class GetComponent implements OnInit, OnDestroy{
  user!: User
  $destroyed = new Subject<boolean>()

  constructor(private readonly _userService:UserService, private _router:Router) {
  }

  ngOnInit() {
      this._userService.getOne().pipe(
        takeUntil(this.$destroyed)
      ).subscribe({
        next: (value) => this.user = value,
        error: (err) => alert(err.message),
        complete: ()=> console.log("chargement terminé")
        }
      )
  }

  disconnect(){
    localStorage.clear()
    this._router.navigate(['user/login'])
  }

  ngOnDestroy() {
      this.$destroyed.next(true);
      this.$destroyed.complete();
  }

  protected readonly localStorage = localStorage;
  role: string | null= localStorage.getItem("role1");
}
