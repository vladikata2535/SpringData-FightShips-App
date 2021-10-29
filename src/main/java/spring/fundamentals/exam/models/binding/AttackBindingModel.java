package spring.fundamentals.exam.models.binding;

public class AttackBindingModel {

    private Long attacker;
    private Long defender;

    public AttackBindingModel() {
    }

    public Long getAttacker() {
        return attacker;
    }

    public AttackBindingModel setAttacker(Long attacker) {
        this.attacker = attacker;
        return this;
    }

    public Long getDefender() {
        return defender;
    }

    public AttackBindingModel setDefender(Long defender) {
        this.defender = defender;
        return this;
    }
}
