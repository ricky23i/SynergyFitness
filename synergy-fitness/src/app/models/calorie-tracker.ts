import { Person } from "./person";

export class CalorieTracker {
    constructor(
        public trackerid:number,
        public totalCalories:number,
        public foodlist:string
    ){}
}
