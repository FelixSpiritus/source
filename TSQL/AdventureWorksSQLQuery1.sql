SELECT * FROM [Person].[Person]

SELECT [Title], [FirstName], [LastName], [MiddleName] FROM [Person].[Person]

SELECT ProductNumber, Name, ListPrice, Color, Size, Weight
FROM [Production].[Product]
WHERE ListPrice < $100

SELECT ProductNumber, Name, ListPrice, Color, Size, Weight
FROM [Production].[Product]
WHERE ListPrice < $100
AND ProductNumber LIKE 'SO%'

SELECT ProductNumber, Name, ListPrice, Color, Size, Weight
FROM [Production].[Product]
WHERE ListPrice < $100
AND ProductNumber LIKE 'SO%'
	OR  ProductNumber LIKE 'TG%'



SELECT ProductNumber, Name, ListPrice, Color, Size, Weight
FROM [Production].[Product]
WHERE ListPrice < $100
AND ProductNumber LIKE 'SO%'
	OR (ListPrice Between $50 and $180
	AND ProductNumber LIKE 'TG%'
	AND SIZE IN ('M','L'))

SELECT ProductNumber, Name, Weight
FROM [Production].[Product]
WHERE ProductLine IS NULL

SELECT [ProductNumber], [Name], [Weight],
ISNULL (ProductLine, 'NA') 
FROM [Production].[Product]


SELECT [ProductNumber], [Name], [Weight],
ISNULL (ProductLine, 'NA') AS 'Product Line'
FROM [Production].[Product]

SELECT * FROM [Production].[Product]

SELECT [ProductNumber], [Name], COALESCE(CONVERT(NVARCHAR,Weight), SIZE, 'NA') AS Measurement,
ISNULL (ProductLine, 'NA') AS 'Product Line'
FROM [Production].[Product]

SELECT ProductNumber, Name, Class
FROM Production.Product
ORDER BY Class 

SELECT ProductNumber, Name, Class
FROM Production.Product
ORDER BY Class, ListPrice Desc

SELECT DISTINCT Color
FROM Production.Product 
WHERE ProductNumber LIKE 'HL%'

SELECT LastName +','+FirstName 
FROM Person.Person 

SELECT LastName +','+FirstName AS Contacts
FROM Person.Person

SELECT LastName +','+FirstName AS Contacts
FROM Person.Person 
WHERE SUBSTRING (LastName,1,3)='Mac'

SELECT * FROM HumanResources.Employee
ORDER BY JobTitle 

SELECT AVG(VacationHours) AS 'AverageVacationHours',
SUM(SickLeaveHours) AS 'TotalSickLeave Hours'
FROM HumanResources.Employee
WHERE JobTitle LIKE '%Vice President%'

SELECT ISNULL (AddressLine2, '0') FROM Person.Address

SELECT COUNT(*)
FROM Person.Address 
WHERE ISNULL (AddressLine2, '0')='0'

SELECT COUNT(*)
FROM HumanResources.Employee

SELECT COUNT(DISTINCT AddressLine2)
FROM Person.Address

SELECT ProductID, AVG(DaysToManufacture) AS 'AvgDaysToManufacture'
FROM Production.Product


--SELECT DISTINCT(ProductID) FROM Production.Product

SELECT AVG(DaysToManufacture) AS 'AvgDaysToManufacture'
FROM Production.Product

SELECT Color, AVG(ListPrice) AS 'AvgListPrice'
FROM Production.Product
WHERE ProductNumber ='FR-R72R-58'
GROUP BY ALL Color

SELECT DISTINCT(ProductID) FROM Sales.SalesOrderDetail

SELECT ProductID, AVG(OrderQty) AS 'AverageQuanyity',
SUM(LineTotal) AS 'Total'
FROM Sales.SalesOrderDetail
GROUP BY ProductID
HAVING SUM(LineTotal) > $1000000.00 and AVG(OrderQty) < 3

SELECT ProductID, Shelf, SUM(Quantity) AS 'QtySum'
FROM [Production].[ProductInventory]
GROUP BY ROLLUP(ProductID, Shelf)

SELECT SalesOrderID, ProductID,
SUM(OrderQty) AS 'SumQuantity'
FROM Sales.SalesOrderDetail
GROUP BY CUBE(SalesOrderID, ProductID)
ORDER BY SalesOrderID, ProductID

SELECT SalesQuota, SUM(SalesYTD) 'TotalSalesYTD',
GROUPING(SalesQuota) AS 'Grouping'
FROM Sales.SalesPerson
GROUP BY CUBE(SalesQuota)

SELECT ProductID, Shelf, SUM(Quantity) AS 'TotalQuantity',
GROUPING (Shelf) AS 'Shelfgrouping'
FROM [Production].[ProductInventory]
GROUP BY CUBE(ProductID, Shelf)


SELECT Name, [RED],[BLUE],[BLACK]
FROM (SELECT SafetyStockLevel, Color, Name FROM
Production.Product) P
PIVOT
(SUM (SafetyStockLevel) FOR Color IN([RED],[BLUE],[BLACK])) AS PVT
WHERE Name LIKE '%Helmet%' ORDER BY Name

SELECT Name, Attribute, Value
FROM
	(SELECT Name, CAST(ProductLine as Sql_Variant) ProductLine,
	CAST(StandardCost as Sql_variant) StandartCost,
		CAST (ListPrice as sql_variant) ListPrice
FROM Production.Product) P UNPIVOT (Value FOR Attribute IN([ProductLine],[StandartCost],[ListPrice]))
AS UnPVT ORDER BY Name Desc

SELECT * FROM Production.Product
		

