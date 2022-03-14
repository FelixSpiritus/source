using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebMVCR1.Models
{
    public struct BankAccount
    {
        public long accNo;
        public decimal accBal;
        public AccountType accType;
        public override string ToString()
        {
            string res = String.Format("Номер счета {0}, баланс {1}, тип {2}", accNo, accBal, accType);
            return res;
        }
    }
    public enum AccountType
    {
        Checking,
        Deposit
    }
    public class StudyCsharp
    {
    }
}