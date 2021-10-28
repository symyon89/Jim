package equipment;

import java.time.LocalDate;


public abstract class Equipment {
   private String name;
   protected String group;
   protected String type;
   private LocalDate dateLastCheck;
   private int maxUsage;
   private LocalDate dateLastClean;
   private int cleaningInterval;

    public Equipment(String name, String group, String type, LocalDate dateLastCheck, int maxUsage, LocalDate dateLastClean, int cleaningInterval) {
        this.name = name;
        this.group = group;
        this.type = type;
        this.dateLastCheck = dateLastCheck;
        this.maxUsage = maxUsage;
        this.dateLastClean = dateLastClean;
        this.cleaningInterval = cleaningInterval;
    }

    public Equipment() {
    }

    public boolean returnTrueIfNeedsCleaning(){
        LocalDate now =LocalDate.now();
        LocalDate dateToClean = dateLastClean.plusDays(cleaningInterval);

        return now.equals(dateToClean) || now.isAfter(dateToClean);
    }
    public boolean returnTrueIfNeedsRepairs(){
        LocalDate now =LocalDate.now();
        LocalDate dateToRepair = dateLastCheck.plusDays(maxUsage);

        return now.equals(dateToRepair) || now.isAfter(dateToRepair);
    }

    public abstract void defineTypeField();
    public abstract void defineGroupField();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateLastCheck() {
        return dateLastCheck;
    }

    public void setDateLastCheck(LocalDate dateLastCheck) {
        this.dateLastCheck = dateLastCheck;
    }

    public int getMaxUsage() {
        return maxUsage;
    }

    public void setMaxUsage(int maxUsage) {
        this.maxUsage = maxUsage;
    }

    public LocalDate getDateLastClean() {
        return dateLastClean;
    }

    public void setDateLastClean(LocalDate dateLastClean) {
        this.dateLastClean = dateLastClean;
    }

    public int getCleaningInterval() {
        return cleaningInterval;
    }

    public void setCleaningInterval(int cleaningInterval) {
        this.cleaningInterval = cleaningInterval;
    }

    public String getGroup() {
        return group;
    }

    public String getType() {
        return type;
    }
}
