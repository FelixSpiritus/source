/*
======================
 ������������ �������
======================
���� �������-��������, �� ������� �� ������������ �������� ������.
���� ���� ������� �������, ���� �� ���������� ������ �� �������-���������.
������� ������ ����� ������ ���������, �� ������ �����.
�� ������ � ��������� �������� ������ �����, ������� ������������ ���������/ ��������/ ������� ������ ������.

���������� � �������:
1. ���������� ������� �� ������� ���� ������ � ����� ���������. � ���� �� �� �������� 2 �������: �������� �
���� ������� �������.
2. ���������� ������� � ��������� �������, ��������� ������� ����:
*/

USE PracticeTask
GO

CREATE SCHEMA Istochnik;  
GO  

CREATE SCHEMA NashaBaza;  
GO  

CREATE TABLE Istochnik.TableSource (
LineId bigint IDENTITY (1,1) PRIMARY KEY NOT NULL,
nPokazatelId bigint NOT NULL, -- ����� ����������
vPeriodType varchar(1) NOT NULL, -- ������ ����������
dtStartDate date NOT NULL, -- ���� ������ ��������� �������
dtEndDate date NOT NULL, -- ���� ����� ��������� �������
vTerritoryId varchar(10) NOT NULL, -- ID ���������� � ������� (ID ������� _ ID ���������)
nValue decimal(32,4) NOT NULL -- �������� ����������
)
GO

INSERT INTO Istochnik.TableSource
VALUES
(2588,'m',CAST('2019-05-01' as date),CAST('2019-06-30' as date),'55_4789',45.64),
(2589,'m',CAST('2019-05-01' as date),CAST('2019-06-30' as date),'55_4889',88.34),
(3600,'m',CAST('2019-06-01' as date),CAST('2019-07-31' as date),'55_4889',81.51),
(3600,'q',CAST('2019-01-01' as date),CAST('2019-03-31' as date),'55_4889',64.42),
(4719,'m',CAST('2019-05-01' as date),CAST('2019-06-30' as date),'55_4889',47.33),
(8543,'m',CAST('2019-05-01' as date),CAST('2019-07-31' as date),'42_1550',20.24),
(8543,'m',CAST('2019-08-01' as date),CAST('2019-09-30' as date),'42_1550',03.15),
(8543,'m',CAST('2019-07-01' as date),CAST('2019-08-31' as date),'55_4789',86.06),
(4719,'q',CAST('2019-06-01' as date),CAST('2019-09-30' as date),'55_4789',69.97),
(3600,'m',CAST('2019-05-01' as date),CAST('2019-06-30' as date),'55_4789',42.88),
(3600,'m',CAST('2019-05-01' as date),CAST('2019-03-31' as date),'55_4789',25.79),
(2588,'m',CAST('2019-05-01' as date),CAST('2019-06-30' as date),'16_8647',08.60),
(2589,'q',CAST('2019-03-01' as date),CAST('2019-06-30' as date),'55_4789',81.51),
(2589,'q',CAST('2019-03-01' as date),CAST('2019-06-30' as date),'55_4789',64.42),
(2589,'q',CAST('2019-03-01' as date),CAST('2019-06-30' as date),'16_8647',47.33),
(2589,'m',CAST('2019-05-01' as date),CAST('2019-06-30' as date),'55_4789',20.24),
(2589,'m',CAST('2019-05-01' as date),CAST('2019-06-30' as date),'16_8647',03.15),
(2589,'m',CAST('2019-05-01' as date),CAST('2019-06-30' as date),'16_8647',86.06),
(2589,'m',CAST('2019-05-01' as date),CAST('2019-06-30' as date),'16_8647',69.87),
(2589,'m',CAST('2019-05-01' as date),CAST('2019-06-30' as date),'55_4789',41.98)
GO

CREATE TABLE NashaBaza.OurTable (
PropId bigint IDENTITY (1,1) PRIMARY KEY NOT NULL,
nCanonId int NOT NULL, -- ����� ����������
dtReportDate date NOT NULL, -- ���� ����� ��������� �������
nTerOtdelenie int NOT NULL, -- ID �������
nTerPodrazdel int NOT NULL, -- ID ���������
vProcent decimal(6,4) NOT NULL -- �������� ����������
)
GO

INSERT INTO NashaBaza.OurTable
VALUES
(2588,CAST('2019-06-30' as date),55,4789,45.64),
(2589,CAST('2019-06-30' as date),55,4889,88.34),
(3600,CAST('2019-07-31' as date),55,4889,81.51),
(4719,CAST('2019-06-30' as date),55,4889,47.33),
(8543,CAST('2019-07-31' as date),42,1550,20.24),
(8543,CAST('2019-08-31' as date),55,4789,83.06),
(3600,CAST('2019-06-30' as date),55,4789,42.88),
(3600,CAST('2019-03-31' as date),55,4789,25.79),
(2588,CAST('2019-06-30' as date),16,8647,08.60),
(2589,CAST('2019-06-30' as date),55,4789,20.24),
(2589,CAST('2019-06-30' as date),16,8647,03.15),
(2589,CAST('2019-06-30' as date),16,8647,86.06),
(2589,CAST('2019-06-30' as date),16,8647,69.87),
(2589,CAST('2019-06-30' as date),55,4789,41.98)
GO

/*
3. ����������� ������� ����������� � �������� ������ � �������� �������� �� ���� ������ � �������� ��������.
*/


/*
������ 1.
���������� ����������� �������� ���������, ������� ���������, ��������� �� ������ �� ����� ���� �
�������-���������. ���� ����� ������ ���������, �� �� �� ����������� � ����.
���� � ��� ��� ������������ ������ �� ��������� ���� � �������-���������, �� ����� ���������
"������ �� ��������� ���� ������ ����������������" � ���������� ���������.

������ 2.
����������� ��������� ��������� �������:
��������� ������ ������� ����������� ����� �������� ���� ����������� �� ��������� ���� � ��������� � �������
� ����������� ������ �������� ���� ����������� �� �� �� ���� � ����� �������.
��� �������� � ����������� ������ - �������������� ������ �� ��������� ����.
��� ���������� - �������� ��������� "������ �� ��������� ���� ������ ����������������".
�������� �������� �� ��, ��� ���������� � NULL ������.

������ 3.
����������� ��������� ��������� �������:
��������� ������ �� ��������� �������� � ��������� ��������� ����� � ���������.
�� ��� �������� ���������� ����, ������ ��������� ��.
����������� ��� �����, ������� ��������� �������� ��������.
���, ��������, ��� �������� � �������� ��������� NULL, ��������� ����� �������� � ����������� ������
� ������������ ��������� ��������� ���� � �������-���������.
���� � �������� ��������� ������ ������������ ����, �� ��� ����� �������� � ���.
*/

USE PracticeTask
GO
SELECT * FROM [Istochnik].[TableSource]
SELECT * FROM [NashaBaza].[OurTable]

SELECT [nPokazatelId], [dtEndDate], SUBSTRING([vTerritoryId],1,2), SUBSTRING([vTerritoryId],4,4), [nValue] FROM Istochnik.TableSource

SELECT MAX([dtReportDate]) FROM [NashaBaza].[OurTable]
SELECT * FROM [NashaBaza].[OurTable]


USE PracticeTask
GO
DECLARE @TDATE DATE;
DECLARE @SDATE DATE;
SET @TDATE = (SELECT MAX([dtReportDate]) FROM [NashaBaza].[OurTable1]);
SET @SDATE = (SELECT MAX([dtEndDate]) FROM [Istochnik].[TableSource]);

--SET @TDATE='2019-06-30';
SELECT @TDATE as TDate;
SELECT @SDATE as SDate;
IF (@TDATE IS NULL)
INSERT INTO NashaBaza.OurTable1 SELECT [nPokazatelId], [dtEndDate], SUBSTRING([vTerritoryId],1,2), SUBSTRING([vTerritoryId],4,4), [nValue] FROM Istochnik.TableSource;
	ELSE
	--SELECT MAX([dtReportDate]) FROM [NashaBaza].[OurTable1]
	INSERT INTO NashaBaza.OurTable1 SELECT [nPokazatelId], [dtEndDate], SUBSTRING([vTerritoryId],1,2), SUBSTRING([vTerritoryId],4,4), [nValue] FROM Istochnik.TableSource
		WHERE [dtEndDate]>@TDATE;
		
SELECT * FROM [NashaBaza].[OurTable1];


--TRUNCATE TABLE [NashaBaza].[OurTable1];

USE PracticeTask
GO
exec [NashaBaza].[pt_Task1];



MERGE NashaBaza.OurTable1 AS T
USING Istochnik.TableSource AS S
ON (T.dtReportDate = S.dtEndDate) 
WHEN NOT MATCHED BY TARGET 
    THEN INSERT([nCanonId],[dtReportDate],[nTerOtdelenie],[nTerPodrazdel],[vProcent])
	VALUES([nPokazatelId], [dtEndDate], SUBSTRING([vTerritoryId],1,2), SUBSTRING([vTerritoryId],4,4), [nValue]);
SELECT * FROM [NashaBaza].[OurTable1],[Istochnik].[TableSource]
WHERE PropId = LineId;
SELECT SUM(DATEPART(yyyy,[dtReportDate])),SUM(DATEPART(yyyy,[dtEndDate])) FROM [NashaBaza].[OurTable1],[Istochnik].[TableSource];

SELECT * FROM [NashaBaza].[OurTable1];
--SELECT [dtReportDate] as TDate FROM [NashaBaza].[OurTable1] LEFT JOIN [Istochnik].[TableSource] ON [dtReportDate]=[dtEndDate] WHERE [dtReportDate] IS NULL;
SELECT * FROM [Istochnik].[TableSource];
INSERT INTO NashaBaza.OurTable1 SELECT [nPokazatelId], [dtEndDate], SUBSTRING([vTerritoryId],1,2), SUBSTRING([vTerritoryId],4,4), [nValue]
FROM [Istochnik].[TableSource] LEFT JOIN [NashaBaza].[OurTable1] ON [dtReportDate]=[dtEndDate] WHERE [dtReportDate] IS NULL;
SELECT * FROM [NashaBaza].[OurTable1];


USE PracticeTask
GO
DECLARE @GDATE DATE;
DECLARE @TDATE DATE;
DECLARE @SDATE DATE;
DECLARE @TSUM BIGINT;
DECLARE @SSUM BIGINT;
SET @SDATE = (SELECT MAX([dtEndDate]) FROM [Istochnik].[TableSource]);
IF (@SDATE IS NULL) SELECT '� �������� ������� ��� ������ ��� ����������' AS Report;
ELSE
	BEGIN
		SET @TDATE = (SELECT MAX([dtReportDate]) FROM [NashaBaza].[OurTable1]);
		IF (@GDATE IS NOT NULL) SET @SDATE = @GDATE;
		SELECT @TDATE AS TDATE;
		IF (@TDATE IS NULL)
			BEGIN
				INSERT INTO NashaBaza.OurTable1 SELECT [nPokazatelId], [dtEndDate], SUBSTRING([vTerritoryId],1,2), SUBSTRING([vTerritoryId],4,4), [nValue]
				FROM Istochnik.TableSource
				WHERE [dtEndDate]=@SDATE;
				SELECT '������ ���������'AS Report;
			END
			ELSE
				BEGIN
					IF (@GDATE IS NOT NULL) SET @TDATE = @GDATE; 
					SET @TSUM = (SELECT SUM(DATEPART(YEAR,[dtReportDate]))+SUM(DATEPART(MM,[dtReportDate]))+SUM(DATEPART(DD,[dtReportDate])) FROM [NashaBaza].[OurTable1]
					WHERE [dtReportDate]=@TDATE);
					SET @SSUM = (SELECT SUM(DATEPART(YEAR,[dtEndDate]))+SUM(DATEPART(MM,[dtEndDate]))+SUM(DATEPART(DD,[dtEndDate])) FROM [Istochnik].[TableSource]
					WHERE [dtEndDate]=@SDATE);
					IF @TSUM = @SSUM SELECT '������ �� ��������� ���� ������ ����������������' AS Report, @TSUM, @SSUM;
					ELSE
						BEGIN
						DELETE FROM [NashaBaza].[OurTable1] WHERE [dtReportDate] = @SDATE;
						INSERT INTO NashaBaza.OurTable1 SELECT [nPokazatelId], [dtEndDate], SUBSTRING([vTerritoryId],1,2), SUBSTRING([vTerritoryId],4,4), [nValue]
						FROM Istochnik.TableSource
						WHERE [dtEndDate]=@SDATE;
						SELECT '������ ����������������'AS Report;
						SELECT @TSUM as TSUM, @SSUM as SSUM;
						END	
				END
	END
			
			
		
SELECT * FROM [NashaBaza].[OurTable];
SELECT * FROM [Istochnik].[TableSource];
TRUNCATE TABLE [NashaBaza].[OurTable];
TRUNCATE TABLE [Istochnik].[TableSource];

exec [NashaBaza].[pt_Task1];
exec [NashaBaza].[pt_Task2];
exec [NashaBaza].[pt_Task3] @GDATE='2019-03-31';




