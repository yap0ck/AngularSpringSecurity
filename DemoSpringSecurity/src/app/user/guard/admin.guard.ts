import {CanActivateChildFn, CanActivateFn} from '@angular/router';
const ADMIN_ROLE: string = 'ADMIN'
export const adminGuard: CanActivateChildFn = (route, state) => {
  let i: number = 1;
  while (true) {
    let role: string | null = localStorage.getItem('role' + i);
    if (!role) {
      return false;
    }
    if (role === ADMIN_ROLE) {
      return true;
    } else {
      i++;
    }
  }
};
