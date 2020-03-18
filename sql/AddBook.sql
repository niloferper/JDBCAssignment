CREATE DEFINER=`root`@`localhost` PROCEDURE `AddBook`(IN bookId int, IN bookTitle varchar(50), IN bookAuthor varchar(50), IN bookPrice float, IN bookQty int)
BEGIN
INSERT into books values (bookId,bookTitle,bookAuthor,bookPrice,bookQty);
END