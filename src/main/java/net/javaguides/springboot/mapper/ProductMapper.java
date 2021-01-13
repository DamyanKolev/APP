package net.javaguides.springboot.mapper;

import net.javaguides.springboot.dto.request.ProductRequest;
import net.javaguides.springboot.dto.response.ProductResponse;
import net.javaguides.springboot.model.Product;

import java.util.List;

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
    Product mapProduct(ProductRequest productRequest);

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "productName", source = "product.productName")
    @Mapping(target = "description", source = "product.description")
    @Mapping(target = "category", source = "product.category")
    @Mapping(target = "color", source = "product.color")
    @Mapping(target = "quantityPerUnit", source = "product.quantityPerUnit")
    @Mapping(target = "unitPrice", source = "product.unitPrice")
    @Mapping(target = "unitWeight", source = "product.unitWeight")
    @Mapping(target = "unitInStock", source = "product.unitInStock")
    ProductResponse mapToDto(Product product);

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "productName", source = "product.productName")
    @Mapping(target = "description", source = "product.description")
    @Mapping(target = "category", source = "product.category")
    @Mapping(target = "color", source = "product.color")
    @Mapping(target = "quantityPerUnit", source = "product.quantityPerUnit")
    @Mapping(target = "unitPrice", source = "product.unitPrice")
    @Mapping(target = "unitWeight", source = "product.unitWeight")
    @Mapping(target = "unitInStock", source = "product.unitInStock")
    List<ProductResponse> mapToListDto(List<Product> product);
}
