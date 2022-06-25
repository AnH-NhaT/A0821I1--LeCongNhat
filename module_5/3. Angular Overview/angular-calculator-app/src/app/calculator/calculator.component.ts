import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  constructor() {
  }

  num1: number;
  ope: string;
  num2: number;
  result: string;
  res: number;

  ngOnInit(): void {
  }

  getOper(val: any) {
    switch (val) {
      case '+':
        this.ope = '+'
        break
      case '-':
        this.ope = '-'
        break
      case '*':
        this.ope = '*'
        break
      case '/':
        this.ope = '/'
        break
    }

  }

  equal(num1: number, num2: number, ope: string) {

    switch (ope) {
      case '+':
        this.res = num1 + num2;
        break
      case '-':
        this.res = num1 - num2;
        break
      case '*':
        this.res = num1 * num2;
        break
      case '/':
        this.res = num1 / num2;
        break
    }
    this.result = '=' + this.res
  }
}
