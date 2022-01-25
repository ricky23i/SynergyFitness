import { Component, Input, OnInit } from '@angular/core';
import { CalorieTracker } from 'src/app/models/calorie-tracker';
import { Person } from 'src/app/models/person';
import { UserService } from 'src/app/services/user.service';
@Component({
  selector: 'app-calorie',
  templateUrl: './calorie.component.html',
  styleUrls: ['./calorie.component.css'],
})
export class CalorieComponent implements OnInit {
  caltracker:CalorieTracker;
  currentDate= new Date();
  message:string="";
  user:Person;
 
  constructor(public userServ:UserService) { }
  
  ngOnInit(): void {
   // this.caltracker=this.userServ.loggedInUser.tracker;
 
    this.userServ.checkLogin().then(resp => {
      this.user=this.userServ.loggedInUser;
      console.log(this.user);
    });
  }
    
    async addCalories(){
      if (this.userServ.loggedInUser){
        this.caltracker=this.user.calorieTracker;
        this.caltracker.trackerId=this.user.calorieTracker.trackerId;
        this.caltracker.foodList=this.caltracker.foodList +":"+ (<HTMLInputElement>document.getElementById("foodl")).value;
        console.log((<HTMLInputElement>document.getElementById("foodl")).value);
        this.caltracker.totalCalories=this.caltracker.totalCalories +(<HTMLInputElement>document.getElementById("calsadd")).valueAsNumber;
        this.user.calorieTracker=this.caltracker;
        console.log(this.caltracker.totalCalories);
        console.log(this.user.calorieTracker);
        let success = await this.userServ.updateUser(this.user);
        this.message="Calories Updated!";
      }
      
    } 
  
}