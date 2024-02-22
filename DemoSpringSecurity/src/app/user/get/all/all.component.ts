import {Component, OnDestroy, OnInit} from '@angular/core';
import {UserService} from "../../service/user.service";
import {Subject, takeUntil} from "rxjs";

@Component({
  selector: 'app-all',
  templateUrl: './all.component.html',
  styleUrl: './all.component.css'
})
export class AllComponent implements OnInit, OnDestroy{
  tableau!: string[]
  $destroyed = new Subject<boolean>();
  constructor(private readonly _userService: UserService) {
  }
  ngOnInit() {
      this._userService.getAll().pipe(
        takeUntil(this.$destroyed))
        .subscribe({
          next: (value) => this.tableau = value,
          error: (err) => alert(err.message),
          complete: () => console.log("chargement terminé")
        });
  }

  ngOnDestroy() {
      this.$destroyed.next(true);
      this.$destroyed.complete();
  }
}
