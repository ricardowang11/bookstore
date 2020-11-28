package edu.ncu.ricardowang.myPracticalClass;

import java.util.Objects;

public class ShoppingCartItem {
    public int ammount;
    public String TITLE;
    public String ID;

    public float PRICE;

    public ShoppingCartItem(BookDetails book) {
        ammount=1;
        TITLE=book.TITLE;
        ID=book.ID;
        PRICE=book.PRICE;
    }

    public ShoppingCartItem(String ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCartItem that = (ShoppingCartItem) o;
        return ID.equals(that.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

}
