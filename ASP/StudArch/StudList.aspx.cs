using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace StudArch
{
    public partial class StudList : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack)
            {

                Page.Validate();
                if (!Page.IsValid) return;

            }

        }

        //protected void Students_RowCommand(object sender, GridViewCommandEventArgs e)
        //{
        //    // Insert data if the CommandName == "Insert" 
        //    // and the validation controls indicate valid data...
        //    if (e.CommandName == "Insert" && Page.IsValid)
        //    {
        //        // Insert new record
        //        SqlDataSource1.Insert();
        //    }
        //}

        protected void AddStudent_Click(object sender, EventArgs e)
        {

            //var tmp = ((TextBox)GridView1.FooterRow.FindControl("Name")).Text;

            Students Student = new Students(((TextBox)GridView1.FooterRow.FindControl("Name")).Text, ((TextBox)GridView1.FooterRow.FindControl("Patronomic")).Text, ((TextBox)GridView1.FooterRow.FindControl("Surname")).Text);
            try
            {
                StudArch context = new StudArch();
                context.Students.Add(Student);
                context.SaveChanges();
            }
            catch (Exception ex)
            {
                Response.Redirect("Ошибка " + ex.Message);
            }
            GridView1.DataBind();
        }

      
    }

        
}