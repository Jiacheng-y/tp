package tracko.model.order;

import static tracko.commons.util.CollectionUtil.requireAllNonNull;

import tracko.model.item.InventoryItem;
import tracko.model.item.Item;
import tracko.model.item.Quantity;
import tracko.model.item.RecordedItem;

/**
 * Represents an item and quantity pair to be added to an {@code Order's} item list.
 * */
public class ItemQuantityPair<T extends Item> {

    private final T item;
    private Quantity quantity;

    /**
     * Constructs an ItemQuantityPair with the given Item and Quantity.
     * @param item The given item
     * @param quantity The given quantity
     */
    public ItemQuantityPair(T item, Quantity quantity) {
        requireAllNonNull(item, quantity);
        this.item = item;
        this.quantity = quantity;
    }

    /**
     * Returns the referenced {@code Item} object of this ItemQuantityPair.
     */
    public T getItem() {
        return item;
    }

    /**
     * Returns the item name of the referenced {@code Item} object of this ItemQuantityPair.
     */
    public String getItemName() {
        return item.getItemName().toString();
    }

    /**
     * Get the referenced {@code Quantity} object of this ItemQuantityPair.
     */
    public Quantity getQuantity() {
        return quantity;
    }

    /**
     * Sets the {@code Quantity} of this ItemQuantityPair.
     */
    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns true if the given {@code ItemQuantityPair} has the same item.
     */
    public boolean hasSameItem(ItemQuantityPair<T> otherPair) {
        return item.isSameItem(otherPair.item);
    }

    /**
     * Returns the quantity value of the referenced {@code Quantity} object of this ItemQuantityPair.
     */
    public Integer getQuantityValue() {
        return quantity.getValue();
    }

    /**
     * Returns a new {@code ItemQuantityPair} that holds an immutable copy of this {@code ItemQuantityPair}'s item
     * @return A new {@code ItemQuantityPair} that holds an immutable copy of this {@code ItemQuantityPair}'s item
     */
    public ItemQuantityPair<RecordedItem> freeze() {
        return new ItemQuantityPair<>(item.freeze(), quantity);
    }

    /**
     * Returns true if the referenced {@code Item} has sufficient quantity to be delivered.
     * @return True if the referenced {@code Item} has sufficient quantity to be delivered.
     */
    public boolean isDeliverable() {
        return (item instanceof InventoryItem) && ((InventoryItem) item).hasMoreThan(quantity);
    }

    @Override
    public String toString() {
        return quantity + " * " + this.getItemName();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof ItemQuantityPair)) {
            return false;
        }

        ItemQuantityPair otherPair = (ItemQuantityPair) other;
        return getItem().equals(otherPair.getItem())
            && getQuantity().equals(otherPair.getQuantity());
    }
}
