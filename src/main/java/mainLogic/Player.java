package mainLogic;

public class Player {
    public Colors getColor() {
        return color;
    }

    private Colors color;

    public playerType getType() {
        return type;
    }

    public Player(Colors color, playerType type) {
        this.color = color;
        this.type = type;
    }

    private playerType type;
}
