using System;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity;
using System.Linq;

namespace StudArchivements.MVC.ExamTask.Models
{
    public partial class SAEDM : DbContext
    {
        public SAEDM()
            : base("name=SAEDMdb")
        {
        }

        public virtual DbSet<Grades> Grades { get; set; }
        public virtual DbSet<Students> Students { get; set; }
        public virtual DbSet<StudResults> StudResults { get; set; }
        public virtual DbSet<Subjects> Subjects { get; set; }
        public virtual DbSet<Fivebest> Fivebest { get; set; }
        public virtual DbSet<Fiveworst> Fiveworst { get; set; }
        public virtual DbSet<NameResults> NameResults { get; set; }
        public virtual DbSet<Sumrating> Sumrating { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Grades>()
                .HasMany(e => e.StudResults)
                .WithRequired(e => e.Grades)
                .WillCascadeOnDelete(false);

            modelBuilder.Entity<Students>()
                .HasMany(e => e.StudResults)
                .WithRequired(e => e.Students)
                .HasForeignKey(e => e.Stud_id)
                .WillCascadeOnDelete(false);

            modelBuilder.Entity<Subjects>()
                .HasMany(e => e.StudResults)
                .WithRequired(e => e.Subjects)
                .WillCascadeOnDelete(false);
        }
    }
}
