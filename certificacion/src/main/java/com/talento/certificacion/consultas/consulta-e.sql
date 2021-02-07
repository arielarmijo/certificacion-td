/*
 e) El gerente general de la compañía desea conocer el valor total del inventario (inventario valorizado)
    existente en cada almacén. Para llevar a cabo dicho requerimiento, confeccione un reporte que acumule
    el costo de cada producto multiplicado por la cantidad, agrupado por almacén y ordenado de forma
    descendente por dicho valor.
*/
select w.warehouse_name,
       sum(p.list_price * i.quantity) as inventario_valorizado
from products p
     inner join
     inventories i using(product_id)
     inner join
     warehouses w using(warehouse_id)
group by w.warehouse_name
order by inventario_valorizado desc;