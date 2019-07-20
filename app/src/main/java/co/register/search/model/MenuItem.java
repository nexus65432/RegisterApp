package co.register.search.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "MenuItem")
public class MenuItem {

    @PrimaryKey(autoGenerate = true)
    int id;
    String itemName;
    String itemPrice;
    int isAvailable;

    @Ignore
    public MenuItem(String itemName, String itemPrice, int isAvailable) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.isAvailable = isAvailable;
    }

    public MenuItem(int id, String itemName, String itemPrice, int isAvailable) {
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(int isAvailable) {
        this.isAvailable = isAvailable;
    }

}
