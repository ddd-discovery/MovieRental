package com.ddd.discovery.movierental;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.javalite.test.jspec.JSpec.$;

public class CustomerTest {
    private Customer customer;

    @BeforeMethod
    public void setUp() {
        customer = new Customer("小李");
        customer.addRental(new Rental(new Movie("完美爸爸", Movie.CHILD), 4));
        customer.addRental(new Rental(new Movie("孤注一掷", Movie.NEW_RELEASE), 5));
        customer.addRental(new Rental(new Movie("流浪地球2", Movie.HISTORY), 6));
    }

    @Test
    public void shouldReturnCorrectResultWhenCallStatement() {
        $("Rental Record for 小李：\n" +
                "\t完美爸爸\t3.0\n" +
                "\t孤注一掷\t15.0\n" +
                "\t流浪地球2\t8.0\n" +
                "Amount owed is 26.0\n" +
                "You earned 4 frequent renter points").shouldBeEqual(customer.statement());
    }

    @AfterMethod
    public void tearDown() {
        customer = null;
    }
}
