namespace StudArchivements.MVC.ExamTask.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    public partial class StudResults
    {
        public long id { get; set; }

        public long Stud_id { get; set; }

        [Required]
        [StringLength(50)]
        public string Subject { get; set; }

        public byte Grade { get; set; }

        public virtual Grades Grades { get; set; }

        public virtual Students Students { get; set; }

        public virtual Subjects Subjects { get; set; }
    }
}
