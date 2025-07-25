use sistemaapartado;

show tables;

select * from abonos;
select * from clientes;
select * from correoclientes;
select * from empleados;
select * from productoapartado;
select * from productos;
select * from telefonoclientes;
select * from ticketreserva;
select * from tipoempleado;
select * from tipoproducto;

CALL consultaTablas();
DESC abonos;


CALL consultaParamsTabla('abonos');

Select * from abonos;

select * from clientes;

Select idAbono, abono from abonos;

select * from productos;
select * from productoapartado;
select * from ticketreserva;

select * from productoapartado inner join productos on productoapartado.Apartado_idProducto=productos.idProducto inner join ticketreserva on ticketreserva.idReserva=Apartado_idReserva where productos.EstadoProductos=1;

-- idProducto, NombreProducto, Precio, FechaAparatado as 

select idProdApartado, idProducto, NombreProducto, Precio, Cantidad, FechaApartado from productoApartado inner join productos on productoapartado.Apartado_idProducto=productos.idProducto inner join ticketreserva on productoapartado.Apartado_idReserva=ticketreserva.idReserva;
-- Tablas join producto, productoApartado, ticketreserva
-- Deberia de salir los productos con ID larga ya que se han hecho reservas

-- no salen no se porque no salen 
-- bruh, estaba tomando como la id de producto, la id de la tabla prod apartado

select min(Precio) as Precio, NombreProducto as Nombre, tipoproducto.NombreTipo as Tipo
from productos
inner join tipoproducto on tipoproducto.idTipo = productos.Productos_idTipo 
group by Productos_idTipo;

select * from Productos;
select idProducto, Count(Apartado_idProducto) as numReservas, productos.NombreProducto from productoapartado 
inner join productos on productoapartado.Apartado_idProducto = productos.idProducto
Group by productos.idProducto 
Order by numReservas DESC ;
-- ^ Incorrecto porque no considera cuenta

select * from productoapartado;
select * from ticketreserva;

-- un idReserva se compone por muchos idProdApartado

select idProdApartado, NombreProducto, Cantidad, FechaApartado from productoapartado 
inner join productos on productos.idProducto = productoapartado.Apartado_idProducto
inner join ticketreserva on productoapartado.Apartado_idReserva = ticketreserva.idReserva
where Apartado_idProducto = 123;
-- idProductoApartado

select count(idProdApartado) from productoapartado where Apartado_idProducto = 123;
-- Este cuenta el numero de Registros hechos sobre un producto
-- ^ NO USAR

select sum(Cantidad) from productoApartado where Apartado_idProducto=123;
-- Este cuenta la Cantidad total un producto reservado

-- ----------------------- Mostrar el Producto mas apartado
-- idProducto | nombreProducto | Cantidad
select * from productoapartado;
select * from tipoproducto;

select 
Apartado_idProducto as ID_Producto,
productos.NombreProducto as Nom_Producto,
sum(Cantidad) as Num_Reservas
from productoApartado
inner join productos 
on productos.idProducto = productoApartado.Apartado_idProducto
group by Apartado_idProducto
order by Num_Reservas DESC
LIMIT 5 -- si un tipo no cuenta con
;

-- Muestra el Numero de Resrvas
-- Solo muestra 5 Tablas

-- Obtiene el numero de reservas como la suma total
-- de todas las entradas de Cantidad de una ID de un Producto

-- ---------------------- Mostrar Productos mas apartados que sean 1 o mas Tipos de Productos 

select 
Apartado_idProducto as ID_Producto,
tipoproducto.NombreTipo as Tipo, -- se muestra el Tipo de Producto :3
productos.NombreProducto as Nom_Producto,
sum(Cantidad) as Num_Reservas
from productoApartado
inner join productos 
on productos.idProducto = productoApartado.Apartado_idProducto
inner join tipoproducto -- se realiza la conexion
on productos.Productos_idTipo = tipoproducto.idTipo -- 
Where Productos_idTipo in (1,2,5,9) -- aqui podria recibir como parametros tipos los obtiene en base la id del Tipo
group by Apartado_idProducto
order by Num_Reservas DESC
LIMIT 5
;

select * from tipoproducto;

-- --------------------- Mostrar los productos mas apartados [En base a su Tipo & En fecha especifica] ----
select 
Apartado_idProducto as ID_Producto,
tipoproducto.NombreTipo as Tipo, 
productos.NombreProducto as Nom_Producto,
sum(Cantidad) as Num_Reservas
from productoApartado
inner join productos 
on productos.idProducto = productoApartado.Apartado_idProducto
inner join tipoproducto 
on productos.Productos_idTipo = tipoproducto.idTipo
inner join ticketreserva -- neuva conexion con tabla para obtener fechas de Apartado
on ticketreserva.idReserva = productoapartado.Apartado_idReserva
Where (
	Productos_idTipo in (1,2,5,9) 
	AND
    
    -- debe de haber un valor en el lado derecho para que funcion
    -- Ejemplo
    -- (ticketreserva.FechaApartado between '2025-03-13' and '')
    -- ^ No muestra nada, aunque haya datos registrados
    -- (ticketreserva.FechaApartado between '' and '2025-03-13') 
    -- ^ funciona
    
    -- ( ticketreserva.FechaApartado between '2026-00-00' and '2025-00-00')
    -- ^ esto no funciona 
    
    ( ticketreserva.FechaApartado between '2025-03-13' and '2025-03-13')
    -- ^ esto si funciona 

)-- la tabla almacena las fecha de apartado
group by Apartado_idProducto
order by Num_Reservas DESC
LIMIT 5
;

select * from ticketreserva;
select * from productoapartado;
-- --------------------------

-- Crear tabla que muestre

-- IdProducto - Nombre del Producto - Precio - Numero de Apartados - Fecha de Apartado

-- !!! A las de arriba falta agregarle el precio

-- Id del Producto | se hace un grupo por la Id del Producto
-- Tabla productoApartado almacena
-- 	productoapartado.Apartado_idProducto = productos.idProducto
--  Cantidad | Numero en el que la suma aumenta

-- Tabla productos
-- 	NombreProducto 
-- 	Precio

-- Tabla ticketreserva
-- 	FechaApartado






-- Aumenta en base a la 

-- select Count(*) from 
