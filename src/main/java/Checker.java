public class Checker extends Board {
    private FigureType type;
    private Boolean team;//true white, false black
    Checker(){}
    Checker(FigureType type){
        this.type = type;
    }

    public FigureType getType() {
        return type;
    }

    public Boolean getTeam() {
        return team;
    }

    public boolean checkMove(Move move) {
        if(type == FigureType.MAN){
            
        } else {

        }
        return false;
    }
}
