import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { environment } from '../../environment/env';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const token = localStorage.getItem('token');
  let authReq = req.clone({
    url: `${environment.apiBaseUrl}${req.url}`
  });
  console.log(`${environment.apiBaseUrl}${req.url}`);
  
  if (token) {
    authReq = authReq.clone({
      setHeaders: {
        Authorization: `Bearer ${token}`
      }
    });
  }

  console.log(authReq);
  
  return next(authReq);
};
