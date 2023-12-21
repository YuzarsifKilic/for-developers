import {Component, OnInit} from '@angular/core';
import {SessionServiceService} from "../_services/session-service.service";

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrl: './demo.component.css'
})
export class DemoComponent implements OnInit {

  constructor(private sessionService: SessionServiceService) {
  }

  ngOnInit(): void {
    this.sessionService.getSessionId();
    this.sessionService.demo();
  }

}
