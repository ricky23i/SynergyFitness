import { Person } from "./person";

export class Post {
    constructor(
        public postId:number,
        public postUser:Person,
        public postData:string
    ){}
}
