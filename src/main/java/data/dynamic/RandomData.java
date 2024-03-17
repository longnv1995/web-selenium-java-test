package data.dynamic;

import com.github.javafaker.Faker;

public class RandomData {
    public static String randEmail() {
        return new Faker().internet().emailAddress();
    }
}
