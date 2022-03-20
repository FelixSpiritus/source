namespace StudArchivements.MVC.ExamTask.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    public partial class Students
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public Students()
        {
            StudResults = new HashSet<StudResults>();
        }

        public long id { get; set; }

        [Required]
        [RegularExpression(@"[a-zA-Z''-'\s]{1,40}", ErrorMessage = "Use ony only latin characters")]
        [StringLength(40)]
        public string Name { get; set; }

        [Required]
        [RegularExpression(@"[a-zA-Z''-'\s]{1,40}", ErrorMessage = "Use ony only latin characters")]
        [StringLength(40)]
        public string Patronomic { get; set; }

        [Required]
        [RegularExpression(@"[a-zA-Z''-'\s]{1,40}", ErrorMessage = "Use ony only latin characters")]
        [StringLength(40)]
        public string Surname { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<StudResults> StudResults { get; set; }
    }
}
