import { Person } from "./person";

export class CalorieTracker {
    constructor(
        public trackerId:number,
        public totalCalories:number,
        public foodList:string
    ){}
}
