package simulator.entities.enums;
import java.util.Objects;

public class Square {

    private Type type;
    private boolean cleared;

    public Square(Type type) {
        this.type = type;
        this.cleared = false;
    }

    public boolean isCleared() {
        return cleared;
    }

    public void setCleared(boolean cleared) {
        this.cleared = cleared;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Square{" +
                " type=" + type +
                ", cleared=" + cleared +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return cleared == square.cleared &&
                type == square.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, cleared);
    }
}
