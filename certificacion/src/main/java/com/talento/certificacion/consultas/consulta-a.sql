/* 
 a) El Product Manager, solicitó un listado de todos los productos de la categoría ‘Storage’,
    con su nombre y precio, ordenados alfabéticamente por nombre.
*/
select p.product_id,
       p.product_name,
       p.list_price
from products p
     inner join
     product_categories c using(category_id)
where category_name = 'Storage'
order by p.product_name;