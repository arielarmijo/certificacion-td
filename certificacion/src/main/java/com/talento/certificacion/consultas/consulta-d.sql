/*
 d) El área de ventas que cubre la ciudad de San Francisco, requiere un listado actualizado
    con los inventarios de los productos ‘Intel’ que existen en el almacén ‘San Francisco’.
    Genere un reporte con la cantidad de inventario de productos ‘Intel’ existentes en dicho almacén,
    ordenado alfabéticamente por producto.
*/
select p.product_id,
       p.product_name,
       i.quantity
from inventories i
     inner join
     products p on p.product_id = i.product_id
     inner join
     warehouses w on i.warehouse_id = w.warehouse_id
where w.warehouse_name = 'San Francisco'
      and
      p.product_name like '%Intel%'
order by p.product_name;