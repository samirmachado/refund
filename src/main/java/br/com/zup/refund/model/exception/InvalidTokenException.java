package br.com.zup.refund.model.exception;

public class InvalidTokenException extends Exception {
    private static final long serialVersionUID = 1L;
    
    @Override
    public String getMessage() {
        return "Token inválido ao fazer login";
    }

}
