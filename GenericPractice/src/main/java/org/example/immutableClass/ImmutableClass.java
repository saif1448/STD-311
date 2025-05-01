package org.example.immutableClass;

public record ImmutableClass(String name, String description) {

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
