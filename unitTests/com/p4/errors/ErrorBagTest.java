package com.p4.errors;

import org.junit.jupiter.api.Test;

class ErrorBagTest {

    private ErrorBag errors = new ErrorBag();

    @Test
    void addEntry_ReceivesACorrectInput_AddsItemToErrors() {
        //Arrange
        var type = ErrorType.TYPE_ERROR;
        var message = "ErrorMessage";

        //Act
        errors.addEntry(type, message);
        var result = !errors.isEmpty();

        //Assert
        assert (result);
    }

    @Test
    void addEntry_ReceivesAlreadyAddedUndeclaredFunctionWarning_SkipsOverAdd() {
        //Arrange
        var type = ErrorType.UNDECLARED_FUNCTION_WARNING;
        var functionName = "func";
        var message = "'" + functionName + "' is not declared in your project.";
        errors.addEntry(type, message);

        //Act
        errors.addEntry(type, message);
        var result = !errors.isEmpty();

        //Assert
        assert (result);
    }

    @Test
    void addEntry_ReceivesWarning_HasErrorsIsFalse() {
        //Arrange

        //Act

        //Assert
    }

    @Test
    void addEntry_ReceivesError_HasErrorsIsTrue() {
        //Arrange

        //Act

        //Assert
    }

    @Test
    void isEmpty() {
    }

    @Test
    void display() {
    }

    @Test
    void containsErrors() {
    }
}