import {Project} from "./project";
import {SocialMedia} from "./social-media";
import {Education} from "./education";
import {Experience} from "./experience";

export class Employee {

  id!: string;
  email!: string;
  firstName!: string;
  lastName!: string;
  phoneNumber!: string;
  githubUsername!: string;
  projects!: Project[];
  socialMedias!: SocialMedia[];
  educations!: Education[];
  experiences!: Experience[];
}
