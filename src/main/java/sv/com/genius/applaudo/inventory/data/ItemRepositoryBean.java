package sv.com.genius.applaudo.inventory.data;

import sv.com.genius.applaudo.inventory.entities.ItemEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ItemRepositoryBean {

    @PersistenceContext(unitName = "persistenceUnit")
    private EntityManager em;

    public ItemRepositoryBean() {

    }

    public ItemEntity insert(ItemEntity item) {
        em.persist(item);
        return item;
    }

    public List<ItemEntity> findAll() {
        return em.createQuery("SELECT i FROM ItemEntity i").getResultList();
    }

    public ItemEntity findOneByItemId(Integer itemId){
        return (ItemEntity) em.createQuery("SELECT i FROM ItemEntity i WHERE ItemEntity.itemId = :itemId")
            .setParameter("itemId", itemId)
            .getSingleResult();
    }

    public List<ItemEntity> findByItemId(Integer itemId){
        return em.createQuery("SELECT i FROM ItemEntity i WHERE i.itemId = :itemId")
            .setParameter("itemId", itemId)
            .getResultList();
    }

    //Optional<Item> findByItemStatusAndItemName(String status, String name);
    public List<ItemEntity> findByItemStatusAndItemName(String status, String name){
        return em.createQuery("SELECT i FROM ItemEntity i WHERE i.itemStatus = :status AND i.itemName = :name")
            .setParameter("status", status)
            .setParameter("name", name)
            .getResultList();
    }

}
