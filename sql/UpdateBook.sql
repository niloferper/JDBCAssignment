CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateBook`(IN bookPrice float, IN bookQty int,IN bookId int)
BEGIN
UPDATE books SET price = bookPrice, qty = bookQty WHERE id = bookId;
END