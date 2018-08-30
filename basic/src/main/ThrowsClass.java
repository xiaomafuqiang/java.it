package main;

import org.junit.Test;

public class ThrowsClass {
    int i = 0;
    @Test
    public void api() {
        try {
            int res = 9 / i;
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
    }

    @Test
    public void myException() {
        try {
            throw new MyException("my exception");
        } catch (MyException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}

class MyException extends Exception {

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return super.initCause(cause);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        // return "----";
        return super.getMessage();
    }
}
