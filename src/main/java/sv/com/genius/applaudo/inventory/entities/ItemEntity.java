package sv.com.genius.applaudo.inventory.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "item")
public class ItemEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "item_id", nullable = false, unique = true)
    private Integer itemId;

    @NotNull
    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "item_entered_by_user")
    private String itemEnteredByUser;

    @Column(name = "item_entered_date")
    @CreationTimestamp
    private LocalDate itemEnteredDate;

    @Column(name = "item_buying_price", precision = 21, scale = 2)
    private BigDecimal itemBuyingPrice;

    @Column(name = "item_selling_price", precision = 21, scale = 2)
    private BigDecimal itemSellingPrice;

    @Column(name = "item_last_modified_date")
    @UpdateTimestamp
    private LocalDate itemLastModifiedDate;

    @Column(name = "item_last_modified_by_user")
    private String itemLastModifiedByUser;

    @Enumerated(EnumType.STRING)
    @Column(name = "item_status")
    private Status itemStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemEnteredByUser() {
        return itemEnteredByUser;
    }

    public void setItemEnteredByUser(String itemEnteredByUser) {
        this.itemEnteredByUser = itemEnteredByUser;
    }

    public LocalDate getItemEnteredDate() {
        return itemEnteredDate;
    }

    public void setItemEnteredDate(LocalDate itemEnteredDate) {
        this.itemEnteredDate = itemEnteredDate;
    }

    public BigDecimal getItemBuyingPrice() {
        return itemBuyingPrice;
    }

    public void setItemBuyingPrice(BigDecimal itemBuyingPrice) {
        this.itemBuyingPrice = itemBuyingPrice;
    }

    public BigDecimal getItemSellingPrice() {
        return itemSellingPrice;
    }

    public void setItemSellingPrice(BigDecimal itemSellingPrice) {
        this.itemSellingPrice = itemSellingPrice;
    }

    public LocalDate getItemLastModifiedDate() {
        return itemLastModifiedDate;
    }

    public void setItemLastModifiedDate(LocalDate itemLastModifiedDate) {
        this.itemLastModifiedDate = itemLastModifiedDate;
    }

    public String getItemLastModifiedByUser() {
        return itemLastModifiedByUser;
    }

    public void setItemLastModifiedByUser(String itemLastModifiedByUser) {
        this.itemLastModifiedByUser = itemLastModifiedByUser;
    }

    public Status getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(Status itemStatus) {
        this.itemStatus = itemStatus;
    }
}
