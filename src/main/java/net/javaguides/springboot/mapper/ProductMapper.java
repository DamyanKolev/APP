package net.javaguides.springboot.mapper;

import net.javaguides.springboot.dto.ProductRequest;
import net.javaguides.springboot.dto.ProductResponse;
import net.javaguides.springboot.model.Product;
import net.javaguides.springboot.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "productName", source = "productRequest.productName")
    @Mapping(target = "description", source = "productRequest.description")
    @Mapping(target = "category", source = "productRequest.category")
    @Mapping(target = "color", source = "productRequest.color")
    @Mapping(target = "quantityPerUnit", source = "productRequest.quantityPerUnit")
    @Mapping(target = "unitPrice", source = "productRequest.unitPrice")
    @Mapping(target = "unitWeight", source = "productRequest.unitWeight")
    @Mapping(target = "unitInStock", source = "productRequest.unitInStock")
    @Mapping(target = "createDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "user", source = "user")
	static
    Product mapProduct(ProductRequest productRequest, User user) {
		// TODO Auto-generated method stub
		return null;
	}

    @Mapping(target = "id", source = "productId")
    @Mapping(target = "produtName", source = "productName")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "color", source = "color")
    @Mapping(target = "quantityPerUnit", source = "quantityPerUnit")
    @Mapping(target = "unitPrice", source = "unitPrice")
    @Mapping(target = "unitWeight", source = "unitWeight")
    @Mapping(target = "unitInStock", source = "unitInStock")
    @Mapping(target = "userName", source = "user.username")
    ProductResponse mapToDto(Product product);
}
