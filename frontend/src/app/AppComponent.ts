import { Component } from '@angular/core';
import { WindowService } from './window.service';


@Component({
  selector: 'app-root',
  standalone: true,
  template: `
  <h1> Movimente o robo em Marte.</h1>
  <h2> Utilize L, M, R para movimentar o robo.</h2>
  
  <input type="text" #nomeInput />
  <p>
  <button (click)="openWindow(nomeInput.value)">Movimentar</button>
      `,
  styleUrl: './app.component.css'
})

export class AppComponent {
  title = 'Robo em Marte';
  valor: string = '';

  constructor(private windowService: WindowService) { }

  openWindow(valor: string) {
    const url = 'localhost:8081/rest/mars/';
    this.windowService.openNewWindow(url + valor);
    
  }
}
