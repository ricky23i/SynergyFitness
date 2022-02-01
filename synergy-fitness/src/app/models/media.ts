import { Post } from "./post";

export class Media {
    constructor(
        public mediaId:number,
        public post:Post,
        public fileName:string,
        public mediaUrl:string
    ){}
}
