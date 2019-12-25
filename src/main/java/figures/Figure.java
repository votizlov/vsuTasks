package figures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import mainLogic.Colors;
import mainLogic.Move;
import mainLogic.Square;

import java.awt.*;
import java.util.LinkedList;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = King.class, name = "King"),

        @JsonSubTypes.Type(value = Man.class, name = "Man") }
)
public interface Figure {
    public LinkedList<Move> getAvailableMoves(Square square);
    public Colors getTeam();
    public Color getDrawable();
    public char getSymbol();
    public void setName(String name);
    public String getName();
}
