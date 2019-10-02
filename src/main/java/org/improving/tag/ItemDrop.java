package org.improving.tag;

        import org.improving.tag.Items.Item;
        import org.improving.tag.Items.UniqueItems;
        import org.springframework.stereotype.Component;


public class ItemDrop {
    public static final ItemDrop NO_TREASURE =
            new ItemDrop(UniqueItems.NOTHING, "");
    private final Item item;
    private final String description;


    public ItemDrop (Item item, String description) {
        this.item = item;
        this.description = description;
    }

    public Item getItem() {
        return item;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public String toString(){
        return description;
    }

}
