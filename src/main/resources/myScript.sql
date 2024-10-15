select  ord.product_name as product_name
from customers cus
  join orders ord on (cus.id = ord.customers_id)
  where lower(cus.name) = :firstName