package equipment.groups;

import equipment.Equipment;

public abstract class FlooringEquipment extends Equipment {
    @Override
    public void defineGroupField() {
        this.group = "Flooring";
    }
}
