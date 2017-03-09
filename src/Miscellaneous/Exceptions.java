package Miscellaneous;


public class Exceptions {
    // There are two types of exceptions

    //1 - Runtime exception

    class MyCustomRuntimeException extends RuntimeException {

    }

    class MyCustomChildRuntimeException extends MyCustomRuntimeException {

    }

    // 2- Checked exception
    class MyCustomCheckedException extends Exception {

    }

    class MyCustomChildCheckedException extends MyCustomCheckedException {

    }

    // How to use runtime exception
    public void throwsRuntimeException() {
        throw new MyCustomRuntimeException();
    }

    public void throwRuntimeExceptionWithThrows() throws MyCustomChildRuntimeException {
        throw new MyCustomChildRuntimeException();
    }

    public void howToUseRuntimeException() {
        throwsRuntimeException();
    }

    public void howToUseRUntimeExceptionWithTryCatch() {
        try{
            throwsRuntimeException();
        } catch (RuntimeException e) {
            System.out.println("Caught exception");
        }
    }

    // How to use checked exception
    public void throwCheckedException() throws MyCustomCheckedException {
        throw new MyCustomCheckedException();
    }

    public void useCheckedExceptionOption1() throws MyCustomCheckedException {
        throwCheckedException();
    }

    public void useCheckeExcpetionOption2() {
        try {
            throwCheckedException();
        } catch (MyCustomCheckedException e) {
            System.out.println("Caught checked exception");
        }
    }

    public boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public static void main(String[] args) {

        new Exceptions().howToUseRuntimeException();
    }
}

