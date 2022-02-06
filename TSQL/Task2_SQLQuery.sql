-- ================================================
-- Template generated from Template Explorer using:
-- Create Procedure (New Menu).SQL
--
-- Use the Specify Values for Template Parameters 
-- command (Ctrl-Shift-M) to fill in the parameter 
-- values below.
--
-- This block of comments will not be included in
-- the definition of the procedure.
-- ================================================
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Dmitry
-- Create date: 2022-01-23
-- Description:	Overwrite rows
-- =============================================
CREATE PROCEDURE NashaBaza.pt_Task2 
	
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;
DECLARE @TDATE DATE;
DECLARE @SDATE DATE;
DECLARE @TSUM BIGINT;
DECLARE @SSUM BIGINT;
SET @SDATE = (SELECT MAX([dtEndDate]) FROM [Istochnik].[TableSource]);
IF (@SDATE IS NULL) SELECT 'В исходной таблице нет данных для добавления' AS Report;
ELSE
	BEGIN
		SET @TDATE = (SELECT MAX([dtReportDate]) FROM [NashaBaza].[OurTable]);
		IF (@TDATE IS NULL)
			BEGIN
				INSERT INTO NashaBaza.OurTable SELECT [nPokazatelId], [dtEndDate], SUBSTRING([vTerritoryId],1,2), SUBSTRING([vTerritoryId],4,4), [nValue]
				FROM Istochnik.TableSource
				WHERE [dtEndDate]=@SDATE;
				SELECT 'Данные добавлены'AS Report;
			END
			ELSE
				BEGIN
					SET @TSUM = (SELECT SUM(DATEPART(YEAR,[dtReportDate]))+SUM(DATEPART(MM,[dtReportDate]))+SUM(DATEPART(DD,[dtReportDate])) FROM [NashaBaza].[OurTable]
					WHERE [dtReportDate]=@TDATE);
					SET @SSUM = (SELECT SUM(DATEPART(YEAR,[dtEndDate]))+SUM(DATEPART(MM,[dtEndDate]))+SUM(DATEPART(DD,[dtEndDate])) FROM [Istochnik].[TableSource]
					WHERE [dtEndDate]=@SDATE);
					IF @TSUM = @SSUM SELECT 'Данные на последнюю дату отчета синхронизированы' AS Report;
					ELSE
						BEGIN
						DELETE FROM [NashaBaza].[OurTable] WHERE [dtReportDate] = @SDATE;
						INSERT INTO NashaBaza.OurTable SELECT [nPokazatelId], [dtEndDate], SUBSTRING([vTerritoryId],1,2), SUBSTRING([vTerritoryId],4,4), [nValue]
						FROM Istochnik.TableSource
						WHERE [dtEndDate]=@SDATE;
						SELECT 'Данные синхронизированы'AS Report;
						END	
				END
	END

END
GO
