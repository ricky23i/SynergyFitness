import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-build-guide',
  templateUrl: './build-guide.component.html',
  styleUrls: ['./build-guide.component.css']
})
export class BuildGuideComponent implements OnInit {

  button:string = `
  <div class="col-lg-6">
    <button type="button" class="btn btn-primary btn-sm">Button Sample</button>
    <button type="button" class="btn btn-secondary btn-md">Button Sample</button>
  </div>`;

  text:string=`
  <div class="form-group">
    <label for="txtUsername">Username</label>
    <input type="text" class="form-control" placeholder="Username" id="txtUsername">
  </div>

  <div class="input-group mb-3">
    <span class="input-group-text" id="inputGroup-sizing-default">Number</span>
    <input id="number" type="number" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
  </div>

  <div class="input-group mb-3">
    <span class="input-group-text" id="inputGroup-sizing-default">text</span>
    <input id="text" type="number" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
  </div>`;

  textarea:string=`
  <div class="form-floating">
    <textarea id="txtComment" class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px"></textarea>
    <label for="floatingTextarea2">Comments</label>
  </div>`;

  dropdownbox:string=`
  <div class="input-group mb-3">
    <label class="input-group-text" for="drpBox">Grading Format</label>
    <select class="form-select" id="drpBox">
      <option value="-1" selected>Choose...</option>
      <option value="1" >Option 1</option>
      <option value="2" >Option 2</option>
    </select>
  </div>`;

  datepicker:string=`
  <div class="input-group mb-3">
      <span class="input-group-text" id="inputGroup-sizing-default">Event Date</span>
      <input id="datepicker" type="date" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
  </div>`;

  timepicker:string=`
  <div class="input-group mb-3">
      <span class="input-group-text" id="inputGroup-sizing-default">Event Time</span>
      <input id="timepicker" type="time" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
  </div>`;

  constructor() { }

  ngOnInit(): void {
  }



}
