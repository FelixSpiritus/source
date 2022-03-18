using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace StudArch
{
    public partial class RatingH : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
           
            using (StudArch db = new StudArch())
            {
                var StRes = db.StudResults;
                foreach (StudResults st in StRes)
                    //RatingBox.Items.Add(Convert.ToString(st.Stud_id));
                    RatingBox.Items.Add(st.Stud_id.ToString()+st.Subject+st.Grade.ToString());
            }
        }
    }
}