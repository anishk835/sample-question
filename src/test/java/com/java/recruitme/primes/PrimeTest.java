package com.java.recruitme.primes;

import org.junit.Assert;
import org.junit.Test;

import com.java.recruitme.primes.Prime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Test for @{@link Prime}
 *
 * Write an algorithm that returns all the prime numbers between 0 and N where N is the user input.
 */
public class PrimeTest {

  @Test
  public void shouldReturnEmptyListWhenNIsZero() {
    Prime prime = new Prime();
    List<Integer> primes =  prime.findPrimes(0);
    List<Integer> expectedPrimes = new ArrayList<Integer>();
    Assert.assertEquals(expectedPrimes, primes);
  }

  @Test
  public void shouldReturnTwoWhenNIsTwo() {
    Prime prime = new Prime();
    List<Integer> primes = prime.findPrimes(2);
    List<Integer> expectedPrimes = new ArrayList<Integer>();
    expectedPrimes.add(2);
    Assert.assertEquals(expectedPrimes, primes);
  }

  @Test
  public void shouldReturnPrimeNumbersTillTwentyWhenNIsTwenty(){
    Prime prime = new Prime();
    List<Integer> primes = prime.findPrimes(20);
    List<Integer> expectedPrimes = new ArrayList<Integer>(Arrays.asList(2,3,5,7,11,13,17,19));
    Assert.assertEquals(expectedPrimes, primes);
  }

  @Test
  public void shouldReturnEmptyWhenNIsMinusFive(){
    Prime prime = new Prime();
    List<Integer> primes = prime.findPrimes(-5);
    List<Integer> expectedPrimes = new ArrayList<Integer>();
    Assert.assertEquals(expectedPrimes, primes);
  }

}
