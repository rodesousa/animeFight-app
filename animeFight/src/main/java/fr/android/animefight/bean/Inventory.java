package fr.android.animefight.bean;

import fr.android.animefight.bean.inventory.CaseInventory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rodesousa on 15/03/16.
 */
public class Inventory implements Serializable{
    private List<CaseInventory> cases;

    public Inventory() {
        this.cases = new ArrayList<>();
    }
}
