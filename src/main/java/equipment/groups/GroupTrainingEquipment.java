package equipment.groups;

import equipment.Equipment;

public abstract class GroupTrainingEquipment extends Equipment {

    @Override
    public void defineGroupField() {
        this.group = "Group Training";
    }
}
