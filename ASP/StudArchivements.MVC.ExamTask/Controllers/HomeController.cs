using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Data;
using System.Data.Entity;
using System.Web;
using System.Web.Mvc;
using StudArchivements.MVC.ExamTask.Models;

namespace StudArchivements.MVC.ExamTask.Controllers
{

    public class HomeController : Controller
    {
        private SAEDM db = new SAEDM();
        public ActionResult Index()
        {
            GetNameResults();
            return View();
        }
        private void GetNameResults()
        {
            var AllNameResults = db.NameResults.ToList<NameResults>();
            ViewBag.NameResults = AllNameResults;
        }
        private void GetGrades()
        {
            var allGrades = db.Grades.ToList<Grades>();
            ViewBag.Grades = allGrades;
        }
        private void GetSubjects()
        {
            var allSubjects = db.Subjects.ToList<Subjects>();
            ViewBag.Subjects = allSubjects;
        }
        public ActionResult Rate(int? id)
        {
            GetGrades();
            GetSubjects();
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Students Stud = db.Students.Find(id);
            if (Stud == null)
            {
                return HttpNotFound();
            }
            return View(Stud);
        }

        [HttpPost]
        public ActionResult Rate(Students std, Subjects sbj, Grades gr)
        {
           
            StudResults StdRes = new StudResults();
            StdRes.Stud_id = std.id;
            StdRes.Subject = sbj.Subject;
            StdRes.Grade = gr.Grade;
            db.StudResults.Add(StdRes);
            db.SaveChanges();
            return RedirectToAction("Index");
            
        }

        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Students Stud = db.Students.Find(id);
            if (Stud == null)
            {
                return HttpNotFound();
            }
            return View(Stud);
        }
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "id,Name,Patronomic,Surname")] Students Stud)
        {
            if (ModelState.IsValid)
            {
                db.Entry(Stud).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("CreateStudent");
            }
            return View(Stud);
        }
        private void GetStudents()
        {
            var allStudents = db.Students.ToList<Students>();
            ViewBag.Students = allStudents;
        }

        public ActionResult OneStudentGrades(Students std)
        {
            var OneStudentQwery = from Results in db.NameResults where Results.Stud_id == std.id select Results;
            ViewBag.Grades = OneStudentQwery;
            return View();
        }
       
        [HttpGet]
        public ActionResult CreateStudent()
        {
            GetStudents();
            return View();
        }
        [HttpPost]
        public ViewResult CreateStudent(Students newStd)
        {
            if (ModelState.IsValid)
            {
                
                db.Students.Add(newStd);
                db.SaveChanges();
                GetStudents();
                ViewBag.Message = "New student successfully added";
                return View();
                   
                
            }
            GetStudents();
            return View(); 
        }
        public ActionResult Sumrating()
        {
            var allStudents = db.Sumrating.ToList<Sumrating>();
            ViewBag.Sumrating = allStudents;
            return View();
        }

        public ActionResult Fivebest()
        {
            var allStudents = db.Fivebest.ToList<Fivebest>();
            ViewBag.Fivebest = allStudents;
            return View();
        }
        public ActionResult Fiveworst()
        {
            var allStudents = db.Fiveworst.ToList<Fiveworst>();
            ViewBag.Fiveworst = allStudents;
            return View();
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
    }
}