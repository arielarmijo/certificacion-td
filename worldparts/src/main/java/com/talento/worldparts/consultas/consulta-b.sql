/*
 b) El Product Manager, para realizar una gestión por categoría, requiere saber cuántos
    productos hay en cada categoría. Se le solicita un reporte con la cantidad de productos
    de cada categoría, ordenado de mayor a menor cantidad.
*/
select c.category_name,
       count(*)
from products p
     inner join
     product_categories c using(category_id)
group by c.category_name
order by count(*) desc;