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
-- Description:	Insert rows
-- =============================================
CREATE PROCEDURE NashaBaza.pt_Task1 
	-- Add the parameters for the stored procedure here
	 
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
DECLARE @TDATE DATE;
DECLARE @SDATE DATE;
SET @TDATE = (SELECT MAX([dtReportDate]) FROM [NashaBaza].[OurTable]);
SET @SDATE = (SELECT MAX([dtEndDate]) FROM [Istochnik].[TableSource]);
IF (@SDATE IS NULL) SELECT 'В исходной таблице нет данных для добавления' AS Report;
ELSE
	IF (@TDATE IS NULL)
	BEGIN
	INSERT INTO NashaBaza.OurTable SELECT [nPokazatelId], [dtEndDate], SUBSTRING([vTerritoryId],1,2), SUBSTRING([vTerritoryId],4,4), [nValue] FROM Istochnik.TableSource;
	SELECT 'Данные добавлены'AS Report;
	END
	ELSE
		IF @TDATE = @SDATE SELECT 'Данные на последнюю дату отчета синхронизированы' AS Report;
		ELSE
			BEGIN
			--SELECT MAX([dtReportDate]) FROM [NashaBaza].[OurTable]
			INSERT INTO NashaBaza.OurTable SELECT [nPokazatelId], [dtEndDate], SUBSTRING([vTerritoryId],1,2), SUBSTRING([vTerritoryId],4,4), [nValue] FROM Istochnik.TableSource
			WHERE [dtEndDate]>@TDATE;
			SELECT 'Данные синхронизированы'AS Report;
			END 
END
GO
