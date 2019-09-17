export class Mentor{
    firstName:string;
    lastName:string;
    email:string;
    password:string;
    contactNumber:string;
    linkedinUrl:string;
    regDateTime:string;
    regCode:string;
    skills:string;
    currentCourse:string;
    yearOfExperience:string;
    rating:string;
    selfRating:string;
    status:string;
    role:string='mentor';
 }
 export class MentorSkills
 {
     mentorId:any;
     skillName:string;
     yearsOfExperience:string;
     regDateTime:string;
     trainingsDelivered:string;
     facilities:string;
 }