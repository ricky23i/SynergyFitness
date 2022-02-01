import { Media } from "./media";
import { Person } from "./person";

export class AboutMe {
    constructor(
        public aboutMeId:number,
        public user:Person,
        public description:string,
        public media:Media,
        public age:number,
        public certs:string,
        public experience:string

    ){}
}
