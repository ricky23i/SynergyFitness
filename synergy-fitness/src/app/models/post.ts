import { Person } from "./person";

export class Post {
    constructor(
        public postId:number,
        public user:Person,
        public postData:string,
        public media_url:string
    ){}
}
