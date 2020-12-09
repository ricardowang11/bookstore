package edu.ncu.ricardowang.myJavaBean;

import edu.ncu.ricardowang.myPracticalClass.BookDetails;
import edu.ncu.ricardowang.myPracticalClass.ShoppingCartItem;

import java.util.Iterator;
import java.util.LinkedHashSet;


public class ShoppingCart extends LinkedHashSet<ShoppingCartItem> {
    
    public int numberOfBooks=0;
    public float sumOfPrice=0;
    public void add(BookDetails book) {
        ShoppingCartItem item=new ShoppingCartItem(book);
        ShoppingCartItem shoppingCartItem=findItem(item);
        if (shoppingCartItem==null){
            super.add(item);
            sumOfPrice=sumOfPrice+item.PRICE;
            numberOfBooks++;
        }else{
            shoppingCartItem.ammount++;
            numberOfBooks++;
            sumOfPrice=sumOfPrice+shoppingCartItem.PRICE;
        }
        return;
    }
    private ShoppingCartItem findItem(ShoppingCartItem item){
        Iterator<ShoppingCartItem> iterator=iterator();
        while (iterator.hasNext()){
            ShoppingCartItem shoppingCartItem=iterator.next();
            if (shoppingCartItem.equals(item)){
                return shoppingCartItem;
            }
        }
        return null;
    }

}
