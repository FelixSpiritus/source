using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WebMVCR1.Models;

namespace WebMVCR1.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        //public ActionResult Index()
        //{
        //    return View();
        //}
        public string Index(string hel)
        {
            //int hour = DateTime.Now.Hour;
            //string Greeting = hour < 12 ? "Доброе утро" : "Добрый день" + ", " + hel;
            //return Greeting;

            //string Greeting = ModelClass.ModelHello() + ", " + hel;
            //return Greeting;
            //string res = ExeEnum();
            //return res;
            string res = ExeStruct();
            return res;

        }
        public string ExeEnum()
        {
            AccountType goldAccount;
            AccountType platinumAccount;
            goldAccount = AccountType.Checking;
            platinumAccount = AccountType.Deposit;
            string res1 = String.Format("Тип банковского счета {0}", goldAccount);
            string res2 = String.Format("Тип банковского счета {0}", platinumAccount);
            string res = res1 + "<p>" + res2;
            return res;
        }
        public string ExeStruct()
        {
            BankAccount goldBankAccount;
            goldBankAccount.accType = AccountType.Checking;
            goldBankAccount.accBal = (decimal)3200.00;
            goldBankAccount.accNo = 123;
            //string res = String.Format("Номер счета {0}, баланс {1}, тип {2}", goldBankAccount.accNo, goldBankAccount.accBal, goldBankAccount.accType);
            string res = String.Format("Информация о банковском счете: {0}", goldBankAccount);
            //string str = $"Номер счета {goldBankAccount.accNo}, баланс {goldBankAccount.accBal}, тип {goldBankAccount.accType}";
            return res;
        }

    }
}