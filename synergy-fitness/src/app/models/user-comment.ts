import { Person } from "./person";
import { Post } from "./post";

export class UserComment {
    constructor(
        public id:number,
        public user:Person,
        public post:Post,
        public reply:UserComment,
        public data:string
    ){}
}
