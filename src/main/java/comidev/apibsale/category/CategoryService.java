package comidev.apibsale.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> getCategories() {
        List<Category> categories = categoryRepo.findAll();
        return categories;
    }
}
