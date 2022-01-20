import { Person } from "./person";

export class CalorieTracker {
    constructor(
        public id:number,
        public user:Person,
        public totalcalories:number,
        public foodlist:string
    ){}
}
