#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.exception;

public class BaseException extends RuntimeException {

    private BaseException(String message) {
        super(message);
    }

    private BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public static BaseException create(String message) {
        return new BaseException(message);
    }

    public static BaseException create(String message, Throwable cause) {
        return new BaseException(message, cause);
    }

    public String toJson() {
       return  "{${symbol_escape}"message${symbol_escape}":${symbol_escape}"" + getMessage() + "${symbol_escape}"}";
    }
  
}
