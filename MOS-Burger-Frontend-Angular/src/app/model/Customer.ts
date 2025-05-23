export default class Customer {
    telephone: string;
    name: string ;
    email: string ;

    constructor(telephone:string,name:string,email:string){
        this.telephone =telephone;
        this.name = name;
        this.email = email;
    }
}