package com.tata.storeapp.test;

import com.google.common.base.Strings;
import com.tata.storeapp.models.Transaction;
import com.tata.storeapp.models.TransactionType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumSet;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TransactionTest {

    //Unique transactionId
    private Transaction transaction1, transaction2, transaction3;

    @BeforeEach
    public void getInstance(){
        transaction1 = new Transaction();
        transaction1.setTransactionId(2);
        transaction2 = new Transaction();
        transaction2.setTransactionId(1);

    }

    @Test
    @DisplayName("Test for Unique Transaction ID")
    public void testIsTransactionIdUnique(){

        assertNotEquals(transaction1.getTransactionId(),transaction2.getTransactionId());
    }

    //Non-negative amount value
    @ParameterizedTest
    @ValueSource(ints = {3244, 15843, -7234, 0, 1})
    @DisplayName("Test for Positive Amount")
    public void testIsAmountPositive(int data){
        transaction1.setAmount(data);
        assertTrue(transaction1.getAmount()>0);
    }

    @Test
    public void negativeTestForTransactionInstance(){
        assertThrows(NullPointerException.class, ()->{
            transaction3.getTransactionId();
        });
    }

    @ParameterizedTest
    @CsvFileSource(resources = "./transactionData.csv", numLinesToSkip = 1)
    void testWithCsvFileSource(int TransactionId, int Amount) {
        assertTrue(TransactionId>0);
        assertNotEquals(0, Amount);
    }



//    @Disabled
//    @RepeatedTest(5)
//    void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
//        assertEquals(5, repetitionInfo.getTotalRepetitions());
//    }
//
//    @RepeatedTest(value = 10, name = "{displayName} {currentRepetition}/{totalRepetitions}")
//    @DisplayName("Repeat!")
//    void customDisplayName(TestInfo testInfo, RepetitionInfo repetitionInfo) {
//        assertEquals("Repeat! "+ repetitionInfo.getCurrentRepetition() + "/" +repetitionInfo.getTotalRepetitions(), testInfo.getDisplayName());
//    }
//
//    @RepeatedTest(value = 1, name = RepeatedTest.LONG_DISPLAY_NAME)
//    @DisplayName("Details...")
//    void customDisplayNameWithLongPattern(TestInfo testInfo) {
//        assertEquals("Details... :: repetition 1 of 1", testInfo.getDisplayName());
//    }
//
//    @RepeatedTest(value = 5, name = "Wiederholung {currentRepetition} von {totalRepetitions}")
//    void repeatedTestInGerman() {
//// ...
//    }
}
