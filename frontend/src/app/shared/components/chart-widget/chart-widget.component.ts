import { Component, AfterViewInit, ElementRef, Input } from '@angular/core';
import { Chart } from 'chart.js/auto';

@Component({
  selector: 'app-chart-widget',
  standalone: true,
  template: `<canvas></canvas>`
})
export class ChartWidgetComponent implements AfterViewInit {

  @Input() data: number[] = [];
  @Input() labels: string[] = [];
  @Input() label: string = '';

  constructor(private el: ElementRef) {}

  ngAfterViewInit(): void {
    new Chart(this.el.nativeElement.querySelector('canvas'), {
      type: 'bar',
      data: {
        labels: this.labels,
        datasets: [{
          label: this.label,
          data: this.data
        }]
      }
    });
  }
}
