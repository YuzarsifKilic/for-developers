import {University} from "./university";
import {Course} from "./course";

export class Education {

  id!: number;
  university!: University;
  course!: Course;
  startYear!: number;
  endYear!: number;
  gnp!: number;
  degree!: string;
}
