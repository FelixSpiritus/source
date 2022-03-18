using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace StudArch
{
    public partial class Grade : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            
        }

        protected void Save_Click(object sender, EventArgs e)
        {
            var stdid = Convert.ToInt32(GridView1.SelectedRow.Cells[1].Text);
            
            StudResults StudResult = new StudResults(stdid, DropDownList2.SelectedValue, DropDownList3.SelectedValue);
            
            try

            {
                StudArch context = new StudArch();
                context.StudResults.Add(StudResult);
                context.SaveChanges();
            }
            catch (Exception ex)
            {
                Response.Redirect("Ошибка " + ex.Message);
            }
            //GridView1.DataBind();
            
        }

        protected void GridView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            Save.Enabled = true;
            TextBox1.Text = GridView1.SelectedRow.Cells[1].Text +' '+ GridView1.SelectedRow.Cells[2].Text +' '+ GridView1.SelectedRow.Cells[3].Text + ' ' + GridView1.SelectedRow.Cells[4].Text;
        }
    }
}