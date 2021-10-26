package equipment.groups;

import equipment.Equipment;

public abstract class StrenghtEquipment extends Equipment {

    @Override
    public void defineGroupField() {
        this.group = "Strenght";
    }
}
