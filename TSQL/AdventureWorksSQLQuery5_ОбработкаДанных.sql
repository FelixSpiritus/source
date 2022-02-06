USE [ApressFinancial]
GO
SET QUOTED_IDENTIFIER OFF
GO
INSERT INTO [ShareDetails].[Shares]
           ([ShareDesc]
           ,[ShareTickerID]
           ,[CurrentPrice])
     VALUES
           ("ACME'S HOMEBAKE COOKIES INC",'AHCI',2.34125)
GO

INSERT INTO CustomerDetails.Customers
(CustomerTitleId, CustomerLastName, CustomerFirstName,
CustomerOtherInitials, AdressId, AccountNumber,
AccountTypeId, CleareBalance, UncleareBalance)
VALUES (3, 'Lobel', 'Leonard', NULL, 145, 53431993, 1, 437.97, -10.56)

USE ApressFinancial
GO
DELETE FROM CustomerDetails.Customers
DBCC CHECKIDENT ('CustomerDetails.Customers',RESEED,0)
INSERT INTO CustomerDetails.Customers
(CustomerTitleId, CustomerLastName, CustomerFirstName,
CustomerOtherInitials, AdressId, AccountNumber,
AccountTypeId, CleareBalance, UncleareBalance)
VALUES (1, 'Brust', 'Andrew', 'J.', 133, 18176111, 1, 200.00, 2.00),
(3, 'Lobel', 'Leonard', NULL, 145, 53431993, 1, 437.97, -10.56)

USE ApressFinancial
GO

CREATE TABLE dbo.T1 ( column_1 int IDENTITY, column_2 VARCHAR(30));

INSERT T1 VALUES ('Row #1');
INSERT T1 (column_2) VALUES ('Row #2');

SET IDENTITY_INSERT T1 ON;

INSERT INTO T1 (column_1,column_2) 
    VALUES (-99, 'Explicit identity value');

SELECT column_1, column_2 FROM T1;

SET IDENTITY_INSERT T1 OFF;

INSERT T1 VALUES ('What Row?');

SELECT column_1, column_2 FROM T1;

SET IDENTITY_INSERT T1 ON;

INSERT INTO T1 (column_1,column_2) 
    VALUES (100, 'Explicit identity value');

SELECT column_1, column_2 FROM T1;

SET IDENTITY_INSERT T1 OFF;

INSERT T1 VALUES ('What Row?');

SELECT column_1, column_2 FROM T1

SELECT * FROM T1

USE ApressFinancial
GO
ALTER TABLE CustomerDetails.CustomersProducts
ADD CONSTRAINT PK_CustomersProducts
PRIMARY KEY CLUSTERED
(CustomerFinancialProductID)
ON [PRIMARY]
GO
ALTER TABLE CustomerDetails.CustomersProducts
WITH NOCHECK
ADD CONSTRAINT CK_CustProds_AmtCheck
CHECK (AmountToCollect > 0 )
GO
ALTER TABLE CustomerDetails.CustomersProducts
WITH NOCHECK
ADD CONSTRAINT DF_CustProds_Renewable
DEFAULT (0)
FOR Renewable
GO

INSERT INTO CustomerDetails.CustomersProducts
(CustomerId,FinancialProductID,AmountToCollect,Frequency
,LastCollected,LastCollection,Renewable)
VALUES (1, 1, -100, 0, '24 Aug 2010', '24 Aug 2010', 0)
INSERT INTO CustomerDetails.CustomersProducts
(CustomerId,FinancialProductID,AmountToCollect,Frequency
,LastCollected,LastCollection,Renewable)
VALUES (1, 1, 100, 0, '24 Aug 2010', '20 Aug 2010', 0)

INSERT INTO CustomerDetails.Customers
(CustomerTitleId, CustomerFirstName, CustomerOtherInitials,
CustomerLastName, AdressId, AccountNumber,
AccountTypeId, CleareBalance, UncleareBalance)
VALUES (3, 'Bernie', 'I', 'McGee', 314, 65368765, 1, 6653.11, 0.00),
(2, 'Julie', 'A','Dewson', 2134, 81625422, 1, 53.32, -12.21),
(1, 'Kirsty', NULL,'Hull', 4312, 96565334, 1, 1266.00, 10.32);
INSERT INTO ShareDetails.Shares
(ShareDesc, ShareTickerId,CurrentPrice)
VALUES ('FAT-BELLY.COM','FBC',45.20),
('NetRadio Inc','NRI',29.79),
('Texas Oil Industries','TOI',0.455),
('London Bridge Club','LBC',1.46);

SELECT * FROM CustomerDetails.Customers
SELECT * FROM ShareDetails.Shares

USE ApressFinancial
GO
SELECT * FROM CustomerDetails.Customers
SELECT CustomerFirstName, CustomerLastName, CleareBalance
FROM CustomerDetails.Customers
SELECT CustomerFirstName AS 'First Name',
CustomerLastName AS 'Last Name',
CleareBalance 'Balance'
FROM CustomerDetails.Customers

USE ApressFinancial
GO
UPDATE CustomerDetails.Customers
SET CustomerLastName = 'Brodie'
WHERE CustomerId = 4

USE ApressFinancial
GO
DECLARE @ValueToUpdate VARCHAR(30)
SET @ValueToUpdate = 'McGlynn'
UPDATE CustomerDetails.Customers
SET CustomerLastName = @ValueToUpdate,
CleareBalance = CleareBalance + UncleareBalance,
UncleareBalance = 0
WHERE CustomerLastName = 'Brodie'

SELECT * FROM CustomerDetails.Customers

USE ApressFinancial
GO
DECLARE @WrongDataType VARCHAR(20)
SET @WrongDataType = '4311.22'
UPDATE CustomerDetails.Customers
SET CleareBalance = @WrongDataType
WHERE CustomerId = 4

USE tempdb
GO
SELECT CustomerId, CustomerFirstName,
CustomerOtherInitials, CustomerLastName
INTO dbo.Customers
FROM ApressFinancial.CustomerDetails.Customers

SELECT * FROM dbo.Customers

DELETE FROM dbo.Customers
WHERE CustomerId = 4

DELETE FROM dbo.Customers

TRUNCATE TABLE dbo.Customers
