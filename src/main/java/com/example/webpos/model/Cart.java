package com.example.webpos.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {

    private List<Item> items = new ArrayList<>();

    public boolean addItem(Item item) {
        return items.add(item);
    }

    public boolean removeItem(Item item) {
        if(getItem(item).subQuantity(item.getQuantity())) {
            return true;
        }
        return false;
    }

    public boolean deleteItem(Item item) {
        items.remove(getItem(item));
        return true;
    }

    public boolean containItem(Item item) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getProduct() == item.getProduct()) {
                return true;
            }
        }
        return false;
    }

    public Item getItem(Item item) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getProduct() == item.getProduct()) {
                return items.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        if (items.size() ==0){
            return "Empty Cart";
        }
        double total = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cart -----------------\n"  );

        for (int i = 0; i < items.size(); i++) {
            stringBuilder.append(items.get(i).toString()).append("\n");
            total += items.get(i).getQuantity() * items.get(i).getProduct().getPrice();
        }
        stringBuilder.append("----------------------\n"  );

        stringBuilder.append("Total...\t\t\t" + total );

        return stringBuilder.toString();
    }
}
