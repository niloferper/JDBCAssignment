CREATE DEFINER=`root`@`localhost` PROCEDURE `FindBook`(IN bookId int)
BEGIN
SELECT * FROM books WHERE id = bookId;
END