package equipment.groups;

import equipment.Equipment;

public abstract class CardioEquipment extends Equipment {

    @Override
    public void defineGroupField() {
        this.group = "Cardio";
    }


}
