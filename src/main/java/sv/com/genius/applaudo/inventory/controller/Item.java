package sv.com.genius.applaudo.inventory.controller;

import sv.com.genius.applaudo.inventory.entities.ItemEntity;

import java.util.List;

public interface Item {

    ItemEntity insert(ItemEntity item);
    List<ItemEntity> findAll();
    ItemEntity findOneByItemId(Integer itemId);
    List<ItemEntity> findByItemId(Integer itemId);
    List<ItemEntity> findByItemStatusAndItemName(String status, String name);

}
