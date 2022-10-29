package org.bestwasabi.characters;

public class Vendor implements Seller {

    @Override
    public String sell(Goods goods) {
        String result = "";
        if (goods == Goods.POTION) {
            result = "potion";
        } else if (goods == Goods.SWORD) {
            result = "sword";
        } else if (goods == Goods.ARMOR) {
            result = "armor";
        }
        return result;
    }

    public enum Goods {
        POTION,
        SWORD,
        ARMOR
    }
}
