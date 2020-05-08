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
        errors = new ErrorBag();
        var type = ErrorType.GENERAL_WARNING;
        var message = "E";

        //Act
        errors.addEntry(type, message);

        //Assert
        assert(errors.containsErrors() == false);

    }

    @Test
    void addEntry_ReceivesError_HasErrorsIsTrue() {
        //Arrange
        errors = new ErrorBag();
        var type = ErrorType.TYPE_ERROR;
        var message = "E";

        //Act
        errors.addEntry(type, message);

        //Assert
        assert(errors.containsErrors() == true);
    }

    @Test
    void isEmpty() {
        //Arrange
        errors = new ErrorBag();

        //Assert
        assert(errors.isEmpty() == true);
    }

    @Test
    void isEmpty_NotEmpty() {
        //Arrange
        errors = new ErrorBag();

        var type = ErrorType.TYPE_ERROR;
        var message = "E";

        //Act
        errors.addEntry(type, message);

        //Assert
        assert(errors.isEmpty() == false);
    }

    @Test
    void containsErrors() {
        //Arrange
        errors = new ErrorBag();
        var type = ErrorType.TYPE_ERROR;
        var message = "E";

        //Act
        errors.addEntry(type, message);

        //Assert
        assert(errors.containsErrors() == true);
    }

    @Test
    void containsErrors_NoErrors() {
        //Arrange
        errors = new ErrorBag();
        var type = ErrorType.GENERAL_WARNING;
        var message = "E";

        //Act
        errors.addEntry(type, message);

        //Assert
        assert(errors.containsErrors() == false);
    }
}