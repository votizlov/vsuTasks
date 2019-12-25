package figures;

import mainLogic.Colors;
import mainLogic.Move;
import mainLogic.Square;

import java.awt.*;
import java.util.LinkedList;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SimpleCargoCarriage.class, name = "King"),

        @JsonSubTypes.Type(value = EconomyClassCarrage.class, name = "Man") }
)
public interface Figure {
    public LinkedList<Move> getAvailableMoves(Square square);
    public Colors getTeam();
    public Color getDrawable();
    public char getSymbol();
    public void setName(String name);
    public String getName();
}
