CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteBook`(IN bookId int)
BEGIN
DELETE FROM books WHERE id = bookId;
END