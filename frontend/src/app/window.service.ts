import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class WindowService {
  openNewWindow(url: string, target: string = '_blank', features: string = ''): void {
    window.open(url, target, features);
  }
}
