package net.javaguides.springboot.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import net.javaguides.springboot.dto.request.ProductRequest;
import net.javaguides.springboot.dto.response.ProductResponse;
import net.javaguides.springboot.model.Product;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-13T10:43:41+0200",
    comments = "version: 1.4.1.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 15.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product mapProduct(ProductRequest productRequest) {
        if ( productRequest == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductName( productRequest.getProductName() );
        product.setDescription( productRequest.getDescription() );
        product.setCategory( productRequest.getCategory() );
        product.setColor( productRequest.getColor() );
        product.setQuantityPerUnit( productRequest.getQuantityPerUnit() );
        product.setUnitPrice( productRequest.getUnitPrice() );
        product.setUnitWeight( productRequest.getUnitWeight() );
        product.setUnitInStock( productRequest.getUnitInStock() );

        product.setCreateDate( java.time.Instant.now() );

        return product;
    }

    @Override
    public ProductResponse mapToDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponse productResponse = new ProductResponse();

        productResponse.setProductId( product.getId() );
        productResponse.setProductName( product.getProductName() );
        productResponse.setDescription( product.getDescription() );
        productResponse.setCategory( product.getCategory() );
        productResponse.setColor( product.getColor() );
        productResponse.setQuantityPerUnit( product.getQuantityPerUnit() );
        productResponse.setUnitPrice( product.getUnitPrice() );
        productResponse.setUnitWeight( product.getUnitWeight() );
        productResponse.setUnitInStock( product.getUnitInStock() );

        return productResponse;
    }

    @Override
    public List<ProductResponse> mapToListDto(List<Product> product) {
        if ( product == null ) {
            return null;
        }

        List<ProductResponse> list = new ArrayList<ProductResponse>( product.size() );
        for ( Product product1 : product ) {
            list.add( mapToDto( product1 ) );
        }

        return list;
    }
}
