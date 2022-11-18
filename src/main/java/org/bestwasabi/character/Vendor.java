package org.bestwasabi.character;

public class Vendor implements Seller {

    @Override
    public String sell(Goods goods) {
        String result = "";
        if (goods == Goods.POTION) {
            result = "potion";
        } else if (goods == Goods.WEAPON) {
            result = "sword";
        } else if (goods == Goods.ARMOR) {
            result = "armor";
        }
        return result;
    }

    public enum Goods {
        POTION,
        WEAPON,
        ARMOR
    }
}
