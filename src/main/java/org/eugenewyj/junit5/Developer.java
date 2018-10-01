package org.eugenewyj.junit5;

/**
 * @author Eugene Wang
 * @since 16/10/25
 */
public class Developer {
    private String first;       //first name
    private String last;        //last name

    public Developer(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }
}
