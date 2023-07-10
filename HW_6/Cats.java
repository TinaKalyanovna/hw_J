
/* 
package HW_6;

import java.util.Objects;

public class Cats {
    private String nick;
    private String color;
    private String breed;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cats cats = (Cats) o;
        return Objects.equals(nick, cats.nick) && Objects.equals(color, cats.color) && Objects.equals(breed, cats.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nick, color, breed);
    }

    @Override
    public String toString() {
        return "nick='" + nick + '\'' +
                ", color='" + color + '\'' +
                ", breed='" + breed ;
    }
}
*/