package days.of.code.model;

import java.util.List;

public class DataReturn {
    private List<Item> items;

    public DataReturn(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "DataReturn [items=" + items + "]";
    }

}
