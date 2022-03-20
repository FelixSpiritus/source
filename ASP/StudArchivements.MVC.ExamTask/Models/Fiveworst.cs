namespace StudArchivements.MVC.ExamTask.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("Fiveworst")]
    public partial class Fiveworst
    {
        [Key]
        [Column(Order = 0)]
        [DatabaseGenerated(DatabaseGeneratedOption.None)]
        public long Stud_id { get; set; }

        [Key]
        [Column(Order = 1)]
        [StringLength(40)]
        public string Name { get; set; }

        [Key]
        [Column(Order = 2)]
        [StringLength(40)]
        public string Patronomic { get; set; }

        [Key]
        [Column(Order = 3)]
        [StringLength(40)]
        public string Surname { get; set; }

        public double? AVER { get; set; }
    }
}
