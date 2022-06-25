import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.css']
})
export class ColorComponent implements OnInit {
  mau: string;

  constructor() {
  }

  ngOnInit(): void {
  }

  changeColor(color: string) {
    switch (color) {
      case 'red':
        this.mau = 'red';
        break;
      case 'blue':
        this.mau = 'blue';
        break;
      case 'yellow':
        this.mau = 'yellow';
        break;
      case 'purple':
        this.mau = 'purple';
        break;
    }
  }
}
