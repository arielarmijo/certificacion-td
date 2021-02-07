/*
 c) Un cliente a nivel mundial requiere saber qué bodegas de almacenamiento (warehouses)
    tiene la compañía y dónde se encuentran ubicadas. Para eso, le han solicitado un listado
    de todos los países junto a sus respectivas ubicaciones de almacenes, ordenado alfabéticamente por país.
*/
select c.country_name,
       w.warehouse_name,
       l.address,
       l.city,
       l.state
from warehouses w
     inner join
     locations l using(location_id)
     inner join
     countries c using(country_id)
order by country_name;