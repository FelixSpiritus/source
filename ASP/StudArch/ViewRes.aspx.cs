using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.Entity;

namespace StudArch
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Text_TextChanged(object sender, EventArgs e)
        {

        }

        protected void Add_Click(object sender, EventArgs e)
        {
            //if (Text.Text != "" || Patronomic.Text != "" || Surname.Text != "")
            //{
            //    Students Student = new Students(Name.Text, Patronomic.Text, Surname.Text);
            //    try
            //    {
            //        StudArch context = new StudArch();
            //        context.Students.Add(Student);
            //        context.SaveChanges();
            //    }
            //    catch (Exception ex)
            //    {
            //        Response.Redirect("Ошибка " + ex.Message);
            //    }
            //}
    }
}
}