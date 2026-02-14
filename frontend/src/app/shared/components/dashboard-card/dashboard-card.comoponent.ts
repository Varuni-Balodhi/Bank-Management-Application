import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-dashboard-card',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div class="card shadow-sm p-3 text-center h-100">
      <h5 class="text-muted">{{ title }}</h5>
      <h2 class="fw-bold">{{ value }}</h2>
    </div>
  `
})
export class DashboardCardComponent {
  @Input() title: string = '';
  @Input() value: string | number = '';
}
