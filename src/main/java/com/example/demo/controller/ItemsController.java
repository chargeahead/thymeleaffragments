package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Items;
import com.example.demo.service.ItemsService;

@Controller
@RequestMapping("/inventory")
public class ItemsController {
  
	@Autowired
	ItemsService its;
	
	@RequestMapping(value= {"/all","/"})
	public String getAll(Model model) {
		List<Items> items = its.getAll();
		model.addAttribute("items", items);
		model.addAttribute("heading", "Item Inventory");
		return "itemsView";
	}
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		Optional<Items> i = its.get(id);
		model.addAttribute("item", i);
		model.addAttribute("heading", "Edit Item");
		return "editView";
	}
	@RequestMapping("/update")
	public String edit(Model model, Items item) {
		its.update(item);
		List<Items> items = its.getAll();
		model.addAttribute("items", items);
		model.addAttribute("heading", "Item Inventory");
		return "redirect:/inventory/all";
	}
	@RequestMapping("/add")
	public String add(Model model) {
		Items i = new Items();
		model.addAttribute("item", i);
		model.addAttribute("heading", "Add Item");
		return "editView";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model) {
		Optional<Items> i = its.get(id);
		its.delete(i.get());
		List<Items> items = its.getAll();
		model.addAttribute("items", items);
		model.addAttribute("heading", "Item Inventory");
		return "redirect:/inventory/all";
	}
}
