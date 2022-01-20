import { Post } from "./post";

export class Media {
    constructor(
        public id:number,
        public post:Post,
        public fname:string,
        public url:string
    ){}
}
