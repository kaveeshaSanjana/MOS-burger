package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.ProductDto;
import edu.icet.ecom.entity.ProductEntity;
import edu.icet.ecom.repository.ProductDao;
import edu.icet.ecom.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    final ProductDao productDao;
    final ModelMapper modelMapper;

    public List<ProductDto> getAll() {
        ArrayList<ProductDto> all = new ArrayList<>();
        productDao.findAll().forEach(productEntity -> {
            System.out.println(productEntity);
            all.add(modelMapper.map(productEntity, ProductDto.class));
        });
        return all;
    }

    @Override
    public boolean add(ProductDto productDto) {
        try {
            ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
            productDao.save(productEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ProductDto> search(String name) {
        List<ProductDto> productDtos = new ArrayList<>();
        List<ProductEntity> productEntities = productDao.findByNameContaining(name);
        productEntities.forEach(productEntity ->
            productDtos.add(modelMapper.map(productEntity, ProductDto.class))
        );
        return productDtos;
    }

    @Override
    public ProductDto search(Long id) {
        Optional<ProductEntity> optionalProductEntity = productDao.findById(id);
        return optionalProductEntity.map(productEntity -> modelMapper.map(productEntity, ProductDto.class)).orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        try {
            productDao.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(ProductDto productDto) {
        try {
            ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
            productDao.save(productEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
