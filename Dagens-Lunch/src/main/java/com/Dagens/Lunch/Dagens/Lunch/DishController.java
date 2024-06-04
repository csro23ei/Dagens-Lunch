package com.Dagens.Lunch.Dagens.Lunch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class DishController {
    @Autowired
    private DishRepository dishRepository;

    @GetMapping("/")
    public String getIndex(Model model) {
        return "Index";
    }

    @GetMapping("/Dishes")
    public String getAllDishes(Model model) {
        List<Dish> dishes = (List<Dish>) dishRepository.findAll();
        model.addAttribute("dishes", dishes);
        return "Dishes";
    }

    @GetMapping("/addDish")
    public String addDishForm() {
        return "redirect:/Dishes";
    }

    @PostMapping("/new-dish")
    public String addNewDish(@RequestParam("name") String dishName,
            @RequestParam("description") String dishDescription,
            @RequestParam("dateAdded") Date dateAdded) {
        Dish dish = new Dish();
        dish.setName(dishName);
        dish.setDescription(dishDescription);
        dish.setDateAdded(dateAdded);
        dishRepository.save(dish);
        return "redirect:/dishes";
    }

    @GetMapping("/delete-dish")
    public String deleteDish(@RequestParam int id) {
        dishRepository.deleteById(id);
        return "redirect:/dishes";
    }
}
