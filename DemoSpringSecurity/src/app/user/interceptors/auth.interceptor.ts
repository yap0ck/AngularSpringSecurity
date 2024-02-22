import {HttpEvent, HttpHandler, HttpInterceptor, HttpInterceptorFn, HttpRequest} from '@angular/common/http';
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";
@Injectable()
export class authInterceptor implements HttpInterceptor{
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.log("intercepted")
    let token = localStorage.getItem("token")
    if (!token) return next.handle(req)
    const newReq= req.clone({
      headers: req.headers.set("Authorization", token)
    })
    return next.handle(newReq);
  }
}
