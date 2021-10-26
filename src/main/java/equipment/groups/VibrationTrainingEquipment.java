package equipment.groups;

import equipment.Equipment;

public abstract class VibrationTrainingEquipment extends Equipment {

    @Override
    public void defineGroupField() {
        this.group = "Vibration Training";
    }
}