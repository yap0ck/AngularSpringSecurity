import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Auth} from "../models/Auth";
import {FormGroup} from "@angular/forms";
import {User} from "../models/User";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  controllerUrl = this._apiUrl

  constructor(private readonly _httpClient: HttpClient,
              @Inject('apiUrl') private _apiUrl: string) {
  }

  login(form:FormGroup)  {
    return this._httpClient.post<Auth>(this.controllerUrl+'login',form.value)
  }

  getOne(){
    return this._httpClient.get<User>(this.controllerUrl+'one')
  }

  getAll(){
    return this._httpClient.get<string[]>(this.controllerUrl+'all')
  }
}
