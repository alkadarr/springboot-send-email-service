IF NOT EXISTS(SELECT * FROM sys.databases WHERE name = 'PORTO_DB')
BEGIN
    CREATE DATABASE [PORTO_DB]
END

GO

USE [PORTO_DB]

GO

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='Product' and xtype='U')
BEGIN
    CREATE TABLE [Product] (
        Id BIGINT PRIMARY KEY IDENTITY (1, 1),
		ProductName VARCHAR(250) NOT NULL,
		CreatedDate DATETIME NOT NULL,
		CreatedBy VARCHAR(50) NULL,
		UpdatedDate DATETIME NULL,
		UpdatedBy VARCHAR(50) NULL
    )
END

GO

INSERT INTO [Product] values('Aqua',GETDATE(),'SYSTEM',null,null)
INSERT INTO [Product] values('Aquades',GETDATE(),'SYSTEM',null,null)
INSERT INTO [Product] values('Le Minerale',GETDATE(),'SYSTEM',null,null)
INSERT INTO [Product] values('Sprit',GETDATE(),'SYSTEM',null,null)
INSERT INTO [Product] values('Coca-Cola',GETDATE(),'SYSTEM',null,null)
INSERT INTO [Product] values('Fanta',GETDATE(),'SYSTEM',null,null)
INSERT INTO [Product] values('Vit',GETDATE(),'SYSTEM',null,null)
INSERT INTO [Product] values('Pure Life',GETDATE(),'SYSTEM',null,null)
