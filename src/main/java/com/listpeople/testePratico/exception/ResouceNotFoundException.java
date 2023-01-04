package com.listpeople.testePratico.exception;

public class ResouceNotFoundException extends RuntimeException {

    public ResouceNotFoundException(Object id){
        super("não foi possivel realizar a atualização dos dados da pessoa código "+ id);
    }
}

