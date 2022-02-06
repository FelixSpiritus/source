USE ApressFinancial
GO
INSERT INTO ShareDetails.SharePrices (ShareID,Price,PriceDate)
VALUES (1, 2.155, '1 Aug 2010 10:10AM'),
(1, 2.2125, '1 Aug 2010 10:12AM'),
(1, 2.4175, '1 Aug 2010 10:16AM'),
(1, 2.21, '1 Aug 2010 11:22AM'),
(1, 2.17, '1 Aug 2010 14:54'),
(1, 2.34125, '1 Aug 2010 16:10'),
(2, 41.10, '1 Aug 2010 10:10AM'),
(2, 43.22, '2 Aug 2010 10:10AM'),
(2, 45.20, '3 Aug 2010 10:10AM')
INSERT INTO ShareDetails.Shares (ShareDesc,ShareTickerID,CurrentPrice)
VALUES ( 'FAT-BELLY.COM', 'FBC', 45.20000)

USE ApressFinancial
GO
CREATE VIEW CustomerDetails.v_CustTrans
AS
SELECT TOP (100) PERCENT
c.AccountNumber, c.CustomerFirstName, c.CustomerOtherInitials,
tt.TransactionDescription, t.DateEntered, t.Amount, t.ReferenceDetails
FROM CustomerDetails.Customers AS c
JOIN TransactionDetails.Transactions AS t
ON t.CustomerId = c.CustomerId
JOIN TransactionDetails.TransactionTypes AS tt
ON tt.TransactionTypesId = t.TransactionType
ORDER BY c.AccountNumber ASC, t.DateEntered DESC

USE ApressFinancial
GO
INSERT INTO CustomerDetails.FinancialProducts (ProductID,ProductName)
VALUES (1, 'Regular Savings'),
(2, 'Bonds Account'),
(3, 'Share Account'),
(4, 'Life Insurance');
INSERT INTO CustomerDetails.CustomersProducts
(CustomerId,FinancialProductID,AmountToCollect,
Frequency, LastCollected, LastCollection, Renewable )
VALUES (1, 1, 200, 1, '31 October 2008', '31 October 2025', 0),
(1, 2, 50, 1, '24 October 2010', '24 March 2012', 0),
(2, 4, 150, 3, '20 October 2010', '20 October 2010', 1),
(3, 3, 500, 0, '24 October 2010', '24 October 2010', 0);

USE ApressFinancial
GO
IF EXISTS(SELECT TABLE_NAME FROM INFORMATION_SCHEMA.VIEWS
WHERE TABLE_NAME = 'v_CustFinProducts'
AND TABLE_SCHEMA = 'CustomerDetails')
DROP VIEW CustomerDetails.v_CustFinProducts
GO
CREATE VIEW CustomerDetails.v_CustFinProducts
WITH SCHEMABINDING
AS
SELECT c.CustomerFirstName + ' ' + c.CustomerLastName AS CustomerName,
c.AccountNumber, fp.ProductName, cp.AmountToCollect,
cp.Frequency, cp.LastCollected
FROM CustomerDetails.Customers AS c
JOIN CustomerDetails.CustomersProducts AS cp
ON cp.CustomerId = c.CustomerId
JOIN CustomerDetails.FinancialProducts AS fp
ON fp.ProductID = cp.FinancialProductID

SELECT * FROM CustomerDetails.v_CustFinProducts

ALTER TABLE CustomerDetails.Customers
ALTER COLUMN CustomerFirstName nvarchar(100)

SET ANSI_NULLS ON
GO
SET ANSI_PADDING ON
GO
SET ANSI_WARNINGS ON
GO
SET CONCAT_NULL_YIELDS_NULL ON
GO
SET ARITHABORT ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET NUMERIC_ROUNDABORT OFF
GO

CREATE UNIQUE CLUSTERED INDEX IX_CustFinProdS
ON CustomerDetails.v_CustFinProducts (AccountNumber, ProductName)

SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO