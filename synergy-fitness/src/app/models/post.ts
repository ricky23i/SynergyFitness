import { Person } from "./person";

export class Post {
    constructor(
        public id:number,
        public user:Person,
        public data:string
    ){}
}
