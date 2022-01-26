import { CalorieTracker } from "./calorie-tracker";
import { Post } from "./post";
import { Role } from "./role";

export class Person {
newpost: any;
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
    public lastsignindate:Date,
    public post:Post
){}
}
