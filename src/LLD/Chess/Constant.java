package LLD.Chess;

public class Constant {
    public enum GameStatus {
        ACTIVE, BLACK_WIN, WHITE_WIN, FORFEIT, STALEMATE, RESIGNATION
    }

    public enum AccountStatus {
        ACTIVE, CLOSED, CANCELED, BLACKLISTED, NONE
    }

    public class Address {
        private String streetAddress;
        private String city;
        private String state;
        private String zipCode;
        private String country;
    }

    public class Person {
        private String name;
        private Address address;
        private String email;
        private String phone;
    }
}
