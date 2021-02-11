package com.tata.storeapp.test;

import com.google.common.base.Strings;
import com.tata.storeapp.facades.CustomArgumentsProvider;
import com.tata.storeapp.facades.StringArgumentConverter;
import com.tata.storeapp.models.Transaction;
import com.tata.storeapp.models.TransactionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;

import java.time.temporal.ChronoUnit;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransactionTypeTest {

    @ParameterizedTest
    @DisplayName("Test Transaction Type")
    @EnumSource(value = TransactionType.class, names = {"CARD","WALLET"})
    public void testWithEnumSource(TransactionType transactionType){
        assertTrue(EnumSet.of(TransactionType.CARD, TransactionType.WALLET).
                contains(transactionType));
    }

    @ParameterizedTest
    @NullSource
    void isBlank_ShouldReturnTrueForNullInputs(String input) {
        assertTrue(Strings.isNullOrEmpty(input));
    }

    @ParameterizedTest(name="#{index} - Test with Argument={0}")
    @NullSource
    void test_null_source(String arg) {
        System.out.println("arg => "+arg);
        assertTrue(arg == null);
    }

    @ParameterizedTest
    @ArgumentsSource(CustomArgumentsProvider.class)
    void test_argument_custom(Transaction arg){ assertNotNull(arg);}

    @ParameterizedTest
    @ArgumentsSource(CustomArgumentsProvider.class)
    void test_argument_custom_amount(Transaction arg){
        assertTrue(arg.getAmount()>0);
    }

    @ParameterizedTest
    @EnumSource(ChronoUnit.class)
    void testCaseWithExplicitArgumentConversion(
            @ConvertWith(StringArgumentConverter.class) String arg) {
        assertNotNull(ChronoUnit.valueOf(arg));
    }

    @ParameterizedTest
    @EnumSource(TransactionType.class)
    void testCaseWithExplicitArgumentConversionForTransaction(
            @ConvertWith(StringArgumentConverter.class) String arg) {
        assertNotNull(TransactionType.valueOf(arg));
    }
}
