
class Review {
    constructor(sname, name, pname, bdate, tel, email, origin, grade, review) {
        this.sname = sname;
        this.name = name
        this.pname = pname;
        this.bdate = bdate;
        this.tel = tel;
        this.email = email;
        this.origin = origin;
        this.grade = grade;
        this.review = review;
        console.log("User ", sname, " created");
    }

}

var reviews = [];
function AddReview() {
    if (HumanRev.checkValidity()) {
        var hrev = new Review(HumanRev.sname.value, HumanRev.name.value, HumanRev.pname.value,
            HumanRev.bdate.value, HumanRev.tel.value, HumanRev.email.value, HumanRev.group1.value, HumanRev.range.value, HumanRev.text.value);
        reviews.push(hrev);
        HumanRev.reset();
        console.log("Review from user ", hrev.sname, " added to database");
    }

}
function ViewReviews() {
    console.log(reviews.length)
    for (var i = 0; i < reviews.length; i++) {
        console.log(reviews[i]);
    }

}

