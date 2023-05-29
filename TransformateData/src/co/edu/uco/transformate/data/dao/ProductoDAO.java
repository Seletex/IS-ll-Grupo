package co.edu.uco.transformate.data.dao;

import java.util.List;


import co.edu.uco.transformate.entities.ProductoEntity;

public interface ProductoDAO {
void create(ProductoEntity entity);
	
	List <ProductoEntity> read(ProductoEntity entity);
	
	void update(ProductoEntity entity);
	
	
}
