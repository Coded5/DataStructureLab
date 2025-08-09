package logic;

public class UnitCard {
    private String name;
    private int bloodCost;
    private int power;
    private int health;
    private String flavorText;

    public UnitCard(String name, int bloodCost, int power, int health, String flavorText) {
        this.setName(name);
        this.setBloodCost(bloodCost);
        this.setPower(power);
        this.setHealth(health);
        this.setFlavorText(flavorText);
    }

    public boolean equals(UnitCard other) {
        return this.name.equals(other.getName());
    }

    public String toString() {
        return this.getName() + " (POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank())
            this.name = "Creature";
        else
            this.name = name;
    }

    public int getBloodCost() {
        return bloodCost;
    }

    public void setBloodCost(int bloodCost) {
        this.bloodCost = (bloodCost >= 0) ? bloodCost : 0;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = (power >= 0) ? power : 0;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = (health >= 1) ? health : 1;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

}
