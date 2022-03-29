package sv.com.genius.applaudo.inventory.controller;

import sv.com.genius.applaudo.inventory.data.ItemRepositoryBean;
import sv.com.genius.applaudo.inventory.entities.ItemEntity;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@Remote(Item.class)
public class ItemController implements Item{

    @EJB
    private ItemRepositoryBean itemRepository;

    @Override
    public ItemEntity insert(ItemEntity item) {
        return itemRepository.insert(item);
    }

    @Override
    public List<ItemEntity> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public ItemEntity findOneByItemId(Integer itemId) {
        return itemRepository.findOneByItemId(itemId);
    }

    @Override
    public List<ItemEntity> findByItemId(Integer itemId) {
        return itemRepository.findByItemId(itemId);
    }

    @Override
    public List<ItemEntity> findByItemStatusAndItemName(String status, String name) {
        return findByItemStatusAndItemName(status, name);
    }
}
