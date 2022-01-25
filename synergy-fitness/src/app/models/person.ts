import { CalorieTracker } from "./calorie-tracker";
import { Role } from "./role";

export class Person {
constructor(
    public id:number,
    public firstname:string,
    public lastname:string,
    public username:string,
    public password:string,
    public role:Role,
    public trainer:Person,
    public signincounter:number,
    public calorieTracker:CalorieTracker,
    public lastsignindate:Date
){}
}
